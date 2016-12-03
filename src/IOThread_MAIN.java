import java.util.Iterator;
import java.util.Random;

public class IOThread_MAIN
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException
	{
		int nodes_T	= 10 ;
		PCB	pcbRunning	= null ;
		PCB pcbMain	= new PCB();
		Random r1	= new Random();
		
		for (int ii=0; ii<nodes_T; ii++)
		{
			pcbRunning = d(new PCB());
			System.out.printf("\t%d: %s\n"	,ii	,QReady.get(ii).showPCB());
		}

		CPU_event event = new CPU_event();
		
		while (!QReady.isEmpty() || (Thread.activeCount()>1))
		{
			pcbRunning	= QReady.removeFirst() ;
			
			pcbRunning.add_CPU_used(r1.nextInt(5)+6);
			
			if (pcbRunning.get_CPU_left() <= 0)
			{
				System.out.printf("***\tmain-0050: (%d) process completed\t used: %d \t max: %d\t***\n"
						,pcbRunning.get_ID()
						,pcbRunning.get_CPU_max()
						,pcbRunning.get_CPU_used()
						);
				continue ;				
			}
		
			if (event.get_CPU_event()==2)
			{
				Thread iop	= new Thread(new IOProcess
						(pcbRunning
						,QReady
						));

				iop.start();				
				//	0100
				System.out.printf("***\tmain-0100: thread started %s %d %s\t***\n"
						,iop.getName()
						,iop.getId()
						,iop.getState()
						);		
			}
			else
				QReady.addLast(pcbRunning);
		}
		
		for (int ii=0; ii<QReady.size(); ii++)
			System.out.printf("%s\n"	,QReady.get(ii).showPCB()) ;
		
		System.out.printf("@@@\tdone\t@@@\n");
	}
}
