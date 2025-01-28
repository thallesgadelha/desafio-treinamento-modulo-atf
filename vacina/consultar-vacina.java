private static final String SQL_CONSULTAR_VACINA = "SELECT"
    + "tb_vacina.novacina,"
    + "tb_vacina.nofornecedor,"
    + "tb_vacina.nrlote,"
    + "tb_vacina.dtvacinacao"
    + "FROM"
    + "tb_vacina"
    + "INNER JOIN"
    + "tb_pet_vacina ON tb_pet_vacina.sqvacina  = tb_vacina.sqvacina"
    + "WHERE"
    + "tb_vacina.stregistro = '1'";

public Elemento consultar(Elemento elementoEntrada) {
	Elemento elementoRetorno = UtilidadesElemento.criarElementoRetornoOk();
	
	Connection conx = null;
	
	Consulta consulta = null;

    
	
	try {	
		conx = getConnection();
		
		consulta = GerenciadorPrersistencia.consultar(BancoDeDados.TB_VACINA, SQL_CONSULTAR_VACINA, conx);
		consulta.executar();
		
		while(consulta.proximo()){
            ObjetoPersistente obj = consulta.getObjetoPersistente();
            elementoRetorno.setValor("nome_vacina", obj.getValor("novacina"));
            elementoRetorno.setValor("fornecedor", obj.getValor("nofornecedor"));
            elementoRetorno.setValor("numero_lote", obj.getValor("nrlote"));
            elementoRetorno.setValor("data_vacinacao", obj.getValor("dtvacinacao"));
        }
	} catch (Exception e) {
		elementoRetorno = new ExcecaoEJB_ATF(e, this, true, elementoEntrada).tratar();
	} finally {
		ElementosConexao.fecharConsulta(conx);
	}
	
	return elementoRetorno;
}