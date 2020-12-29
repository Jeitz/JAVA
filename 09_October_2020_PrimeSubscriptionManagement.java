/* For question, please visit https://kingkrab.net/ira-09-oct-2020-xplore-answer-java/ */
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
// TODO Auto-generated method stub
  Scanner sc=new Scanner(System.in);
  Amazonprime[] ap=new Amazonprime[4];
  for(int i=0;i<4;i++)
  {
    int a=sc.nextInt();sc.nextLine();
    String b=sc.nextLine();
    int c=sc.nextInt();sc.nextLine();
    String d=sc.nextLine();
    int e=sc.nextInt();sc.nextLine();
    ap[i]=new Amazonprime(a,b,c,d,e);
  }
  int par1=sc.nextInt();sc.nextLine();
  int par=sc.nextInt();sc.nextLine();
  String show=sc.nextLine();
  int remaindays=findRemainingSubcriptionDays(ap,par,par1);
  if(remaindays!=0)
  {
    System.out.println(remaindays);
  }
  else
    System.out.println("Its time to recharge your Prime Account");

  Amazonprime amp[]=findDetailsForGivenShow(ap,show);
  if(amp!=null)
  {
      for(int i=0;i<amp.length;i++)
      {
          if(amp[i]!=null){
          System.out.println(amp[i].getPrimeId()+"$"+amp[i].getUserName()+"$"+amp[i].getViews());
      }
      }
  }
  else{
      System.out.println("No such shows available");
  }

  }
  public static int findRemainingSubcriptionDays(Amazonprime[] ap,int par,int par1) {
    int remaindays=0;
  for(int i=0;i<ap.length;i++)
  {
    if(ap[i].getPrimeId()==par)
    {
    remaindays=((ap[i].getSubscribedPackage())-par1);
    }
  }
  return remaindays;
  }

  public static Amazonprime[] findDetailsForGivenShow(Amazonprime[] ap,String show) {
    Amazonprime amp[]=new Amazonprime[4];
    int j=0;
    for(int i=0;i<ap.length;i++)
    {
      if(ap[i].getShowStreaming().equalsIgnoreCase(show))
    {
        amp[j++]=ap[i];
    }
    }
    for(int i=0;i<j-1;i++)
    {
      for(int k=0;k<j-1-i;k++)
    {
        if(amp[k].getViews()>amp[k+1].getViews())
    {
      Amazonprime aja=amp[k];
      amp[k]=amp[k+1];
      amp[k+1]=aja;
    }
  }
    }
    if(j!=0)
      {
          return amp;
      }
      else{
          return null;
      }
  }
}
class Amazonprime
{
  int primeId;
  String userName;
  int subscribedPackage;
  String showStreaming;
  int views;
  public Amazonprime(int primeId, String userName, int subscribedPackage, String showStreaming, int views) {
    this.primeId = primeId;
    this.userName = userName;
    this.subscribedPackage = subscribedPackage;
    this.showStreaming = showStreaming;
    this.views = views;
  }
  public int getPrimeId() {
    return primeId;
  }
  public void setPrimeId(int primeId) {
    this.primeId = primeId;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public int getSubscribedPackage() {
    return subscribedPackage;
  }
  public void setSubscribedPackage(int subscribedPackage) {
    this.subscribedPackage = subscribedPackage;
  }
  public String getShowStreaming() {
    return showStreaming;
  }
  public void setShowStreaming(String showStreaming) {
    this.showStreaming = showStreaming;
  }
  public int getViews() {
    return views;
  }
  public void setViews(int views) {
    this.views = views;
  }

}
