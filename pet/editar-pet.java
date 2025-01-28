public Elemento editar(Elemento elementoEntrada) {
	Elemento elementoRetorno = UtilidadesElemento.criarElementoRetornoOk();
	Connection conx = null;
	Consulta consulta = null;
	
	try {	
        UtilidadesElemento.aplicarServico(elementoEntrada, CFG_ALTERAR_PET);

		conx = getConnection();

        String id_pet = elementoEntrada.getValor("pet.sqpet");
        String nome = elementoEntrada.getValor("pet.nopet");
        String raca = elementoEntrada.getValor("pet.racapet");
        String idade = elementoEntrada.getValor("pet.idadepet");
		
		StringBuffer filtro = filtro.append("sqpet = 'id_pet'");
		
		consulta = GerenciadorPrersistencia.consultar(BancoDeDados.TB_PET, filtro, conx);
		consulta.executar();
		
		if(consulta.proximo()){
			ObjetoPersistente obj = consulta.getObjetoPersistente();
			obj.setValor("nopet", nome);
			obj.setValor("racapet", raca);
			obj.setValor("idadepet", idade);
			obj.alterar(elementoEntrada);
		}
	} catch (Exception e) {
		elementoRetorno = new ExcecaoEJB_ATF(e, this, true, elementoEntrada).tratar();
	} finally {
		ElementosConexao.fecharConsulta(conx);
	}
	
	return elementoRetorno;
}