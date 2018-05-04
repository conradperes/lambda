package leitorImagens;

public class LeitorImagens {
	private String diretorioImagens;
	
	
	
	public LeitorImagens() {
		diretorioImagens = getRootDir()+"/images";
	}


	public String getRootDir() {
		return System.getProperty("user.dir");
	}
	
	
	public static void main(String[] args) {
		LeitorImagens images = new LeitorImagens();
		System.out.println(images.diretorioImagens+"/images3.jpg");
		
		

	}

}
