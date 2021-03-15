package com.atguigu.chapter10

class k(){
  var x:Int=_
  var y:Int=_
  val dis = new Array[Int](3)
  var label:Int=_
  def this(x:Int,y:Int){
    this()
    this.x=x
    this.y=y
  }
  override def toString: String = s"[x=$x,y=$y,dis=$dis,label=$label]"
}





