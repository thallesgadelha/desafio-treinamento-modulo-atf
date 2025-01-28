public Elemento editar(Elemento elementoEntrada) {
	Elemento elementoRetorno = UtilidadesElemento.criarElementoRetornoOk();
	Connection conx = null;
	Consulta consulta = null;
	
	try {	
        UtilidadesElemento.aplicarServico(elementoEntrada, CFG_ALTERAR_TUTOR);

		conx = getConnection();

        String id_tutor = elementoEntrada.getValor("tutor.sqtutor");
        String nome = elementoEntrada.getValor("tutor.notutor");
        String telefone = elementoEntrada.getValor("tutor.teltutor");
		
		StringBuffer filtro = filtro.append("sqtutor = 'id_tutor'");
		
		consulta = GerenciadorPrersistencia.consultar(BancoDeDados.TB_TUTOR, filtro, conx);
		consulta.executar();
		
		if(consulta.proximo()){
			ObjetoPersistente obj = consulta.getObjetoPersistente();
			obj.setValor("notutor", nome);
			obj.setValor("teltutor", telefone);
			obj.alterar(elementoEntrada);
		}
	} catch (Exception e) {
		elementoRetorno = new ExcecaoEJB_ATF(e, this, true, elementoEntrada).tratar();
	} finally {
		ElementosConexao.fecharConsulta(conx);
	}
	
	return elementoRetorno;
}