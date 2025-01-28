public Elemento excluir(Elemento elementoEntrada) {
	Elemento elementoRetorno = UtilidadesElemento.criarElementoRetornoOk();
	Connection conx = null;
	Consulta consulta = null;
	
	try {	
		conx = getConnection();
		
        String id_pet = elementoEntrada.getValor("pet.sqpet");

        StringBuffer filtro = filtro.append("sqpet  = 'id_pet'");
		
		consulta = GerenciadorPrersistencia.consultar(BancoDeDados.TB_PET, filtro, conx);
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