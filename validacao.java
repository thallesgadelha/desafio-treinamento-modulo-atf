public class ManterPessoaEJBs extends PersistenceEJB {
	private static final ConfiguradorDeServico CFG_INCLUIR_TUTOR = new ConfiguradorDeServico();
	private static final ConfiguradorDeServico CFG_ALTERAR_TUTOR = new ConfiguradorDeServico();

	private static final ConfiguradorDeServico CFG_INCLUIR_VACINA = new ConfiguradorDeServico();
	private static final ConfiguradorDeServico CFG_ALTERAR_VACINA = new ConfiguradorDeServico();

	private static final ConfiguradorDeServico CFG_INCLUIR_PET = new ConfiguradorDeServico();
	private static final ConfiguradorDeServico CFG_ALTERAR_PET = new ConfiguradorDeServico();
	
	static {
		CFG_INCLUIR_TUTOR.incluirItem("notutor");
		CFG_INCLUIR_TUTOR.setCaminho("tutor");
		CFG_INCLUIR_TUTOR.setObrigatorio("true");
        CFG_INCLUIR_TUTOR.incluirItem("teltutor");
		CFG_INCLUIR_TUTOR.setCaminho("tutor");
		CFG_INCLUIR_TUTOR.setObrigatorio("true");
		CFG_INCLUIR_TUTOR.incluirServico(SEValidaBanco.class);

		CFG_ALTERAR_TUTOR.incluirItem("notutor");
		CFG_ALTERAR_TUTOR.setCaminho("tutor");
		CFG_ALTERAR_TUTOR.incluirItem("teltutor");
		CFG_ALTERAR_TUTOR.setCaminho("tutor");
		CFG_ALTERAR_TUTOR.incluirServico(SEValidaBanco.class);

        CFG_INCLUIR_VACINA.incluirItem("novacina");
        CFG_INCLUIR_VACINA.setCaminho("vacina");
		CFG_INCLUIR_VACINA.setObrigatorio("true");
        CFG_INCLUIR_VACINA.incluirItem("nofornecedor");
        CFG_INCLUIR_VACINA.setCaminho("vacina");
		CFG_INCLUIR_VACINA.setObrigatorio("true");
        CFG_INCLUIR_VACINA.incluirItem("nrlote");
        CFG_INCLUIR_VACINA.setCaminho("vacina");
		CFG_INCLUIR_VACINA.setObrigatorio("true");
		CFG_INCLUIR_VACINA.incluirServico(SEValidaBanco.class);

		CFG_ALTERAR_VACINA.incluirItem("novacina");
		CFG_ALTERAR_VACINA.setCaminho("vacina");
		CFG_ALTERAR_VACINA.incluirItem("nofornecedor");
		CFG_ALTERAR_VACINA.setCaminho("vacina");
		CFG_ALTERAR_VACINA.incluirItem("nrlote");
		CFG_ALTERAR_VACINA.setCaminho("vacina");
		CFG_ALTERAR_VACINA.incluirServico(SEValidaBanco.class);

		CFG_INCLUIR_PET.incluirItem("nopet");
		CFG_INCLUIR_PET.setCaminho("pet");
		CFG_INCLUIR_PET.setObrigatorio("true");
		CFG_INCLUIR_PET.incluirItem("racapet");
		CFG_INCLUIR_PET.setCaminho("pet");
		CFG_INCLUIR_PET.setObrigatorio("true");
		CFG_INCLUIR_PET.incluirItem("idadepet");
		CFG_INCLUIR_PET.setCaminho("pet");
		CFG_INCLUIR_PET.setObrigatorio("true");
		CFG_INCLUIR_PET.incluirItem("chip");
		CFG_INCLUIR_PET.setCaminho("pet");
		CFG_INCLUIR_PET.setObrigatorio("true");
		CFG_INCLUIR_PET.incluirItem("sqtutor");
		CFG_INCLUIR_PET.setCaminho("pet");
		CFG_INCLUIR_PET.setObrigatorio("true");
		CFG_INCLUIR_PET.incluirServico(SEValidaBanco.class);

		CFG_ALTERAR_PET.incluirItem("nopet");
		CFG_ALTERAR_PET.setCaminho("pet");
		CFG_ALTERAR_PET.incluirItem("racapet");
		CFG_ALTERAR_PET.setCaminho("pet");
		CFG_ALTERAR_PET.incluirItem("idadepet");
		CFG_ALTERAR_PET.setCaminho("pet");
		CFG_ALTERAR_PET.incluirItem("chip");
		CFG_ALTERAR_PET.setCaminho("pet");
		CFG_ALTERAR_PET.incluirItem("sqtutor");
		CFG_ALTERAR_PET.setCaminho("pet");
		CFG_ALTERAR_PET.incluirServico(SEValidaBanco.class);
	}
}