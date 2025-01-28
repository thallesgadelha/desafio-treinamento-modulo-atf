public Elemento cadastrarTutor(Elemento elementoEntrada) {
	Elemento elementoRetorno = UtilidadesElemento.criarElementoRetornoOk();
	Connection conx = null;
	
	try {
		UtilidadesElemento.aplicarServico(elementoEntrada, CFG_INCLUIR_TUTOR);

		conx = getConnection();
		
		String nome = elementoEntrada.getValor("tutor.nome");
		String telefone = elementoEntrada.getValor("tutor.telefone");

		ObjetoPersistente obj = new ObjetoPersistente(BancoDeDados,TB_TUTOR, conx);
		
		obj.setValor("notutor", nome);
		obj.setValor("teltutor", telefone);

		obj.incluir(elementoEntrada);
	} catch (Exception e) {
		listaElementoRetorno = new ExcecaoEJB_ATF(e, this, true, elementoEntrada).tratar();
	} finally {
		ElementosConexao.fecharConexao(conx);
	}

	return elementoRetorno;
}