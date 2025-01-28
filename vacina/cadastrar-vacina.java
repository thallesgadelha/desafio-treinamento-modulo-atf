public Elemento cadastrarVacina(Elemento elementoEntrada) {
	Elemento elementoRetorno = UtilidadesElemento.criarElementoRetornoOk();
	Connection conx = null;
	
	try {
		UtilidadesElemento.aplicarServico(elementoEntrada, CFG_INCLUIR_VACINA);

		conx = getConnection();
		
		String nome_vacina = elementoEntrada.getValor("vacina.nome");
		String fornecedor = elementoEntrada.getValor("vacina.fornecedor");
		String lote = elementoEntrada.getValor("vacina.lote");

		ObjetoPersistente obj = new ObjetoPersistente(BancoDeDados,TB_VACINA, conx);
		
		obj.setValor("novacina", nome_vacina);
		obj.setValor("nofornecedor", fornecedor);
        obj.setValor("nrlote", lote);

		obj.incluir(elementoEntrada);
	} catch (Exception e) {
		listaElementoRetorno = new ExcecaoEJB_ATF(e, this, true, elementoEntrada).tratar();
	} finally {
		ElementosConexao.fecharConexao(conx);
	}

	return elementoRetorno;
}