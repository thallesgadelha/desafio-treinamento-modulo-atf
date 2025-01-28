private static final String SQL_CONSULTAR_TUTOR = "SELECT"
    + "tb_tutor.notutor,"
    + "tb_tutor.teltutor,"
    + "tb_pet.nopet,"
    + "tb_pet.racapet,"
    + "tb_pet.idadepet"
    + "FROM"
    + "tb_tutor"
    + "INNER JOIN"
    + "tb_pet ON tb_pet.sqtutor = tb_tutor.sqtutor"
    + "WHERE"
    + "tb_tutor.stregistro = '1'";

public Elemento consultar(Elemento elementoEntrada) {
	Elemento elementoRetorno = UtilidadesElemento.criarElementoRetornoOk();
	
	Connection conx = null;
	
	Consulta consulta = null;
	
	try {	
		conx = getConnection();
		
		consulta = GerenciadorPrersistencia.consultar(BancoDeDados.TB_TUTOR, SQL_CONSULTAR_TUTOR, conx);
		consulta.executar();
		
		while(consulta.proximo()){
            ObjetoPersistente obj = consulta.getObjetoPersistente();
            elementoRetorno.setValor("nome_tutor", obj.getValor("notutor"));
            elementoRetorno.setValor("telefone_tutor", obj.getValor("teltutor"));
            elementoRetorno.setValor("nome_pet", obj.getValor("nopet"));
            elementoRetorno.setValor("raca_pet", obj.getValor("racapet"));
            elementoRetorno.setValor("idade_pet", obj.getValor("idadepet"));
        }
	} catch (Exception e) {
		elementoRetorno = new ExcecaoEJB_ATF(e, this, true, elementoEntrada).tratar();
	} finally {
		ElementosConexao.fecharConsulta(conx);
	}
	
	return elementoRetorno;
}