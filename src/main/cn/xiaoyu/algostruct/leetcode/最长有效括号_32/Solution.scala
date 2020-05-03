package xiaoyu.algostruct.leetcode.最长有效括号_32

import scala.collection.mutable

object Solution {

  def longestValidParentheses(s: String): Int = {
    val stack = mutable.Stack[Int]()
    var max = 0
    stack.push(-1)
    s.zipWithIndex.foreach {
      case (char, index) => {
        if (char == '(') stack.push(index)
        else {
          stack.pop()
          if (stack.isEmpty) {
            stack.push(index)
          }
          else {
            max = math.max(max, index - stack.head)
          }
        }
      }
    }
    max
  }

  def main(args: Array[String]): Unit = {
    println(longestValidParentheses(")()())"))
  }
}
