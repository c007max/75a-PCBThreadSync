import java.util.Random;
import java.util.LinkedList;

public class IOProcess extends Thread
{
	Random	r1 =	new Random();
	private final PCB pcb;
	private final LinkedList<PCB> QReady ;
	
	public IOProcess	(PCB pcb0
						,LinkedList<PCB> qr0
						)
	{
		this.pcb	= pcb0 ;
		this.QReady	= qr0 ;
	}
	
	public void run() 
	{
		pcb.set_state("Wait");
		
		System.out.printf("\t>> IOProcess start ID: %d <<\n"	
				,pcb.get_ID()
				);
		
		try 
		{
			Thread.sleep((r1.nextInt(500)+500));
			this.QReady.addLast(pcb);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		System.out.printf("\t>> IOProcess end for ID: %d \tQR count: %d<<\n"
				,pcb.get_ID()
				,QReady.size()
				);
		return ;
	}
}
