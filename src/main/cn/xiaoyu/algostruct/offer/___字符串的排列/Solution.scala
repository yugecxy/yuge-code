package cn.xiaoyu.algostruct.offer.___字符串的排列

import scala.collection.mutable

/**
  * https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
  */
object Solution {
  def permutation(s: String): Array[String] = {

    var ret = Array[String]()

    def dfs(x: Int, res: String, str: Array[Char]): Unit = {
      if (x == s.length) {
        ret :+= res
        return
      }

      val set = mutable.HashSet[Char]()
      str.indices.foreach(i => {
        if (str(i) != ',' && !set.contains(str(i))) {
          val tmp = str(i)
          str(i) = ','
          dfs(x + 1, res ++ tmp.toString, str)
          str(i) = tmp
          set.add(tmp)
        }
      })
    }

    dfs(0, "", s.toCharArray)

    ret
  }

  /**
    * @return 经典的求全排列的做法
    */
  def permutation2(s: String): Array[String] = {

    var ret = Array[String]()

    def dfs(x: Int, res: String, str: Array[Char]): Unit = {
      if (x == s.length) {
        ret :+= res
        return
      }
      str.indices.foreach(i => {
        if (str(i) != ',') {
          val tmp = str(i)
          str(i) = ','
          dfs(x + 1, res ++ tmp.toString, str)
          str(i) = tmp
        }
      })
    }

    dfs(0, "", s.toCharArray)

    ret
  }

  def main(args: Array[String]): Unit = {
    println(permutation("aab").toSeq)
  }
}
