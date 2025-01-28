public Elemento editar(Elemento elementoEntrada) {
	Elemento elementoRetorno = UtilidadesElemento.criarElementoRetornoOk();
	Connection conx = null;
	Consulta consulta = null;
	
	try {	
        UtilidadesElemento.aplicarServico(elementoEntrada, CFG_ALTERAR_VACINA);

		conx = getConnection();

        String id_vacina = elementoEntrada.getValor("vacina.sqvacina");
        String nome = elementoEntrada.getValor("vacina.novacina");
        String fornecedor = elementoEntrada.getValor("vacina.nofornecedor");
        String lote = elementoEntrada.getValor("vacina.nrlote");
		
		StringBuffer filtro = filtro.append("sqtutor = 'id_tutor'");
		
		consulta = GerenciadorPrersistencia.consultar(BancoDeDados.TB_VACINA, filtro, conx);
		consulta.executar();
		
		if(consulta.proximo()){
			ObjetoPersistente obj = consulta.getObjetoPersistente();
			obj.setValor("novacina", nome);
			obj.setValor("nofornecedor", fornecedor);
			obj.setValor("nrlote", lote);
			obj.alterar(elementoEntrada);
		}
	} catch (Exception e) {
		elementoRetorno = new ExcecaoEJB_ATF(e, this, true, elementoEntrada).tratar();
	} finally {
		ElementosConexao.fecharConsulta(conx);
	}
	
	return elementoRetorno;
}