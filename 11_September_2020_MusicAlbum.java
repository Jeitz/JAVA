import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{

 public static void main(String[] args)
 {
  //code to read values 
  //code to call required method
  //code to display the result
  int songId;
  String title;
  String artist;
  int rating;
  Scanner s = new Scanner(System.in);
  Song[] song = new Song[5];
  for(int i=0;i<5;i++){
      songId = s.nextInt();s.nextLine();
      title = s.nextLine();
      artist = s.nextLine();
      rating = s.nextInt();
      song[i] = new Song(songId, title, artist, rating);
  }
  s.nextLine();
  String artist1 = s.nextLine();
  String artist2 = s.nextLine();
  s.close();

  int findAvg = findAvgRatingForArtist(song, artist1);
  Song[] newSong = searchSongByArtist(artist2, song);

  if(findAvg == 0)
    System.out.println("There are no songs with the given artist");
  else
        System.out.println(findAvg);
    
  if(newSong == null)
    System.out.println("There are no songs available for the given artist");
  else{
      for(int i=0;i<newSong.length;i++){
          System.out.println(newSong[i].getSongId());
      }
  }

 }

public static int findAvgRatingForArtist(Song[] song, String artist)
  {
   //method logic
   int avgRating = 0, count = 0;
   for(int i=0;i<song.length;i++){
       if(artist.equalsIgnoreCase(song[i].getArtist())){
           avgRating += song[i].getRating();
           count++;
       }
   }
   if(avgRating > 0) return avgRating/count;
   else return avgRating;
  }

public static Song[] searchSongByArtist(String artist, Song[] song)
  {
   //method logic
   int count = 0;
   for(int i=0;i<song.length;i++){
       if(artist.equalsIgnoreCase(song[i].getArtist()))
        count++;
   }
   if(count == 0)
    return null;
   Song[] s = new Song[count];
   count = 0;
   for(int i=0;i<song.length;i++){
       if(artist.equalsIgnoreCase(song[i].getArtist())){
           s[count++] = song[i];
       }
   }
   for(int i=0;i<s.length;i++){
       for(int j=i+1;j<s.length;j++){
           if(s[i].getSongId()<=s[j].getSongId()){
               Song temp = s[i];
               s[i] = s[j];
               s[j] = temp;
           }
       }
   }
   return s;
  }
}
    
class Song
{
  //code to build the class
  int songId;
  String title;
  String artist;
  int rating;
  Song(int songId, String title, String artist, int rating){
      this.songId = songId;
      this.title = title;
      this.artist = artist;
      this.rating = rating;
  }
  int getSongId(){
      return songId;
  }
  String getTitle(){
      return title;
  }
  String getArtist(){
      return artist;
  }
  int getRating(){
      return rating;
  }
}
