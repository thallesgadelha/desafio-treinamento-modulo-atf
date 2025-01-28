public Elemento cadastrar(Elemento elementoEntrada) {
	Elemento elementoRetorno = UtilidadesElemento.criarElementoRetornoOk();
	Connection conx = null;
	
	try {
		UtilidadesElemento.aplicarServico(elementoEntrada, CFG_INCLUIR_PET);

		conx = getConnection();
		
		String nome = elementoEntrada.getValor("pet.nopet");
		String raca = elementoEntrada.getValor("pet.racapet");
		String idade = elementoEntrada.getValor("pet.idadepet");
		String chip = elementoEntrada.getValor("pet.chip");
		String id_tutor = elementoEntrada.getValor("pet.id_tutor");

		ObjetoPersistente obj = new ObjetoPersistente(BancoDeDados,TB_PET, conx);
		
		obj.setValor("nopet", nome);
		obj.setValor("racapet", raca);
		obj.setValor("idadepet", idade);
		obj.setValor("nochip", chip);
		obj.setValor("sqtutor", id_tutor);

		obj.incluir(elementoEntrada);
	} catch (Exception e) {
		listaElementoRetorno = new ExcecaoEJB_ATF(e, this, true, elementoEntrada).tratar();
	} finally {
		ElementosConexao.fecharConexao(conx);
	}

	return elementoRetorno;
}