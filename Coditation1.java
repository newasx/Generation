import java.util.Scanner;


public class Coditation1
{
    //method for updated grid elements.   
    public void display(int grid[][],int r,int c,int disp[][])      
         {
             
             
             //loop for every cell
             for(int l=1;l<r-1;l++)
             {
                 for(int m=1;m<c-1;m++)
                 {
                     int alive=0;       //finding alive neighbours
                     
                     for(int i=-1;i<=1;i++)
                         for(int j=-1;j<=1;j++)
                             alive=alive+grid[l+i][m+j];
                             
                             alive=alive-grid[l][m];
                             
                             // implementing rules 
                             //cell with fewer than 2 live neighbours dies.
                             if((grid[l][m]==1) && (alive<2))
                                 disp[l][m]=0;
                         
                             else if((grid[l][m]==1) && (alive==2) || (alive==3))
                                 disp[l][m]=1;
                             //cell with more than 3 live neighbours dies.
                             else if((grid[l][m]==1) && (alive>3))
                                 disp[l][m]=0;
                             
                           
                             //cell with exactly 3 live neighbours live
                             else if((grid[l][m]==0) && (alive==3))
                                 disp[l][m]=1;
                             
                             else
                                 disp[l][m]=grid[l][m];
                         
                 }
             }
             
             System.out.println("New Grid ");
             
             for(int i=0;i<r;i++)
             {
                 for(int j=0;j<c;j++)
                 {
                     System.out.print(disp[i][j]+" ");
                 }
                 System.out.println();
             }
         }
             
             public void Status(int disp[][])
             {
                 Scanner sc= new Scanner(System.in);
                 
                 System.out.println("Enter row to check");
                 int cell1=sc.nextInt();
                 
                 System.out.println("Enter column to check");
                 int cell2 = sc.nextInt();
                 
                 if(disp[cell1][cell2]==1)
                     System.out.println("Cell is live");
                 
                 else
                     System.out.println("Cell is not live");
                 
                 
             }
        
        

    public static void main(String args[])
    {
        
        Coditation1 aa= new Coditation1();
        Scanner sc= new Scanner(System.in);
        
        char choice;
        
        
        
        int r=8;
       
        int c= 8;
        
        
        
        int[][] grid ={{0,0,0,0,0,0,0,0 },
                        {0,0,0,1,0,0,0,0},
                        {0,0,0,1,1,0,0,0},
                        {0,0,0,0,0,0,0,0},  
                        {0,0,1,1,0,0,0,0},
                        {0,0,0,0,0,0,0,0},
                        {0,0,0,0,1,0,0,0},
                        {0,0,0,0,0,0,0,0}
                    };
        
                    int[][] disp = new int[r][c];
                    
                    do
                    {
        
                System.out.println("Grid elements ");   //displaying grid array elements
        
                System.out.println("Represents 0 as dead element and 1 as alive element\n");
                for(int i=0;i<r;i++)
                {
                    for(int j=0;j<c;j++)
                    {
                        System.out.print(grid[i][j]+" ");
                    }
                    System.out.println();
                }
                            
               System.out.println();
               
               System.out.println("\n1.New Grid");
               System.out.println("\n2.Cell status");
               System.out.println("\nEnter ur choice ");
               int  ch=sc.nextInt();
               
               
               switch(ch)
               {
                   case 1 : System.out.println("The next generartion is:\n");
                            aa.display(grid, r, c, disp);
                            break;
                       
                   case 2 : aa.Status(disp);
                       
                            break;
                   default :
                       System.out.println("Wrong choice ");
                       break;
               }
               System.out.println("Do you want to continue(y/n) ");
               choice= sc.next().charAt(0);
                 
           }  while((choice=='y') || (choice=='Y') );
    }
}