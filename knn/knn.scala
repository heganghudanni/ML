package com.atguigu
import collection.mutable.ListBuffer
import collection.mutable
import com.atguigu.chapter10.k
object knn {

 def main(args: Array[String]): Unit = {
     var  k1= new k(1,1)
     val ks: ListBuffer[k] = new ListBuffer[k]
     val kt = new ListBuffer[k]
     val labels = Array(0,0,0,1,1)
     val predict = Array(3,3)
     for (i<-1 to 5)
       ks.append(new k(i,i))
     for(i<-3 to 4)
       ks(i).label=1
    kt.append(new k(-1,-1))
    kt.append(new k(7,7))
    for(i<-0 to kt.length-1){
      val dis = new Array[Double](5)
      for(j<-0 to ks.length-1)
        dis(j)=distance(kt(i),ks(j))
      predict(i)=vote(dis,labels)
    }
   println(predict.mkString(","))
  }
  def distance(a:k,b:k)={
    math.sqrt(((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y)))
  }
  def vote(x:Array[Double],y: Array[Int])={
    val index: Array[Int] = x.zipWithIndex.sortWith(_._1<_._1).take(3).map(_._2)
    val map = mutable.Map[Int,Int]()
    for(i<-0 to index.length-1){
      map(y(index(i)))= map.getOrElse(y(index(i)),0)+1
    }
    val list: List[Int] = map.toList.sortWith(_._2>_._2).take(1).map(_._1)
    list(0)
  }



}
