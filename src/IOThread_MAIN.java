import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class IOThread_MAIN
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException
	{
		PCB_LL pcb_LL	= new PCB_LL();
		
		int nodes_T	= 10 ;
		PCB	pcbRunning	= null ;
		Random r1	= new Random();
				
		for (int ii=0; ii<nodes_T; ii++)
		{
			PCB pcbMain	= new PCB();
			pcb_LL.addFirst(pcbMain)	;
			
			System.out.printf("\t%d: %s\n"	,ii	,pcbMain.showPCB());
		}

		CPU_event event = new CPU_event();

		for (int ii=0; ii<pcb_LL.size(); ii++)
			System.out.printf("%s\n"	,pcb_LL.get(ii).showPCB()) ;
			
		IOProcess iop1	= new IOProcess	(pcbRunning
									,pcb_LL
									)	;

		
		IOProcess iop2	= new IOProcess	(pcbRunning
									,pcb_LL
									)	;
		iop1.start()	;
		iop2.start()	;
		
		iop1.join()	;
		iop2.join()	;
		
		for (int ii=0; ii<pcb_LL.size(); ii++)
			System.out.printf("%s\n"	,pcb_LL.get(ii).showPCB()) ;
		
//		Thread iop	= new Thread(new IOProcess
//			(pcbRunning
//			,pcb_LL
//			));
//
//		iop.start();				
////	0100
//		System.out.printf("***\tmain-0100: thread started %s %d %s\t***\n"
//				,iop.getName()
//				,iop.getId()
//				,iop.getState()
//				);		
//		
//		while (!QReady.isEmpty() || (Thread.activeCount()>1))
//		{
//			pcbRunning	= QReady.removeFirst() ;
//			
//			for
//			
//			pcbRunning.add_CPU_used(r1.nextInt(5)+6);
//			
//			if (pcbRunning.get_CPU_left() <= 0)
//			{
//				System.out.printf("***\tmain-0050: (%d) process completed\t used: %d \t max: %d\t***\n"
//						,pcbRunning.get_ID()
//						,pcbRunning.get_CPU_max()
//						,pcbRunning.get_CPU_used()
//						);
//				continue ;				
//			}
//		
//			if (event.get_CPU_event()==2)
//			{
//				Thread iop	= new Thread(new IOProcess
//						(pcbRunning
//						,QReady
//						));
//
//				iop.start();				
//				//	0100
//				System.out.printf("***\tmain-0100: thread started %s %d %s\t***\n"
//						,iop.getName()
//						,iop.getId()
//						,iop.getState()
//						);		
//			}
//			else
//				QReady.addLast(pcbRunning);
//		}
//		
//		for (int ii=0; ii<QReady.size(); ii++)
//			System.out.printf("%s\n"	,QReady.get(ii).showPCB()) ;
//		
		System.out.printf("@@@\tdone\t@@@\n");
	}
	
	public synchronized PCB getFirst()
	{
		return QReady.getFirst() ;
	}
		
	public synchronized PCB getLast()
	{
		return QReady.getLast()	;
	}
	
	public synchronized PCB get(int	i0)
	{
		return QReady.get(i0)	;
	}
	
	//	set methods
	
	public synchronized void addFirst(PCB pcb0)
	{
		QReady.addFirst(pcb0)	;
	}
	
	public synchronized void addLast(PCB pcb0)
	{
		QReady.addLast(pcb0)	;
	}
	
	public synchronized void add(int i0	,PCB pcb0)
	{
		QReady.add(i0, pcb0)	;
	}
}
