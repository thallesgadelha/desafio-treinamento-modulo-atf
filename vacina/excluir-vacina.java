public Elemento excluir(Elemento elementoEntrada) {
	Elemento elementoRetorno = UtilidadesElemento.criarElementoRetornoOk();
	Connection conx = null;
	Consulta consulta = null;
	
	try {	
		conx = getConnection();
		
        String id_vacina = elementoEntrada.getValor("vacina.sqvacina");

        StringBuffer filtro = filtro.append("sqvacina  = 'id_vacina'");
		
		consulta = GerenciadorPrersistencia.consultar(BancoDeDados.TB_VACINA, filtro, conx);
        consulta.executar();
		
		if(consulta.proximo()){
			ObjetoPersistente obj = consulta.getObjetoPersistente();
            obj.excluir(elementoEntrada);
		}
	} catch (Exception e) {
		elementoRetorno = new ExcecaoEJB_ATF(e, this, true, elementoEntrada).tratar();
	} finally {
		ElementosConexao.fecharConsulta(conx);
	}
	
	return elementoRetorno;
}