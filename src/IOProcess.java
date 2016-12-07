import java.util.Random;
import java.util.LinkedList;

public class IOProcess extends Thread
{
	Random	r1 =	new Random();
	private PCB 	pcb	;
	private PCB_LL	pcbLL	;
	
	public IOProcess	(PCB pcb0
						,PCB_LL	pcb_LL0
						)
	{
		this.pcb	= pcb0 ;
		this.pcbLL	= pcb_LL0 ;
	}
	
	public void run() 
	{
		pcb	= pcbLL.removeFirst()	;
		pcb.set_state("Wait");
		
		System.out.printf("\t>> IOProcess start ID: %d <<\n"	
				,pcb.get_ID()
				);
		
		try 
		{
			Thread.sleep((r1.nextInt(500)+500));
			pcbLL.addLast(pcb);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		System.out.printf("\t>> IOProcess end for ID: %d \tQR count: %d<<\n"
				,pcb.get_ID()
				,pcbLL.size()
				);
		return ;
	}
}
