private static final String SQL_CONSULTAR_PET = "SELECT"
    + "tb_pet.nopet,"
    + "tb_pet.racapet,"
    + "tb_pet.idadepet,"
    + "tb_pet.nrchip,"
    + "tb_tutor.notutor,"
    + "tb_tutor.teltutor,"
    + "tb_vacina.novacina,"
    + "tb_vacina.nofornecedor,"
    + "tb_vacina.nrlote,"
    + "FROM"
    + "tb_pet"
    + "INNER JOIN"
    + "tb_tutor ON tb_tutor.sq_tutor = tb_pet.sqtutor"
    + "INNER JOIN"
    + "tb_pet_vacina ON tb_pet_vacina.sqpet = tb_pet.sqtutor"
    + "INNER JOIN"
    + "tb_vacina ON tb_vacina.sqvacina  = tb_pet.sqvacina"
    + "WHERE"
    + "tb_pet.stregistro = '1'";

public Elemento consultar(Elemento elementoEntrada) {
	Elemento elementoRetorno = UtilidadesElemento.criarElementoRetornoOk();
	
	Connection conx = null;
	
	Consulta consulta = null;
	
	try {	
		conx = getConnection();
		
		consulta = GerenciadorPrersistencia.consultar(BancoDeDados.TB_PET, SQL_CONSULTAR_PET, conx);
		consulta.executar();
		
		while(consulta.proximo()){
            ObjetoPersistente obj = consulta.getObjetoPersistente();
            elementoRetorno.setValor("nome", obj.getValor("nopet"));
            elementoRetorno.setValor("raca", obj.getValor("racapet"));
            elementoRetorno.setValor("idade", obj.getValor("idadepet"));
            elementoRetorno.setValor("numero_chip", obj.getValor("nrchip"));
            elementoRetorno.setValor("nome_tutor", obj.getValor("notutor"));
            elementoRetorno.setValor("telefone_tutor", obj.getValor("teltutor"));
            elementoRetorno.setValor("nome_vacina", obj.getValor("novacina"));
            elementoRetorno.setValor("nome_fornecedor", obj.getValor("nofornecedor"));
            elementoRetorno.setValor("numero_lote", obj.getValor("nrlote"));
        }
	} catch (Exception e) {
		elementoRetorno = new ExcecaoEJB_ATF(e, this, true, elementoEntrada).tratar();
	} finally {
		ElementosConexao.fecharConsulta(conx);
	}
	
	return elementoRetorno;
}