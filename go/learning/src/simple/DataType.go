package main

import (
	"fmt"
)

func main() {
	test1()

	test2()

	test3()

	test4()

	test5()
}

func test5(){
	a := A{}
	fmt.Println(a)
	a.a = 34
	a.b = "jiji"
	fmt.Println(a)

	b := B{3,"1"}
	fmt.Println(b)
	b.int = 3 //用类型代替名称
	b.string = "jiji"
	fmt.Println(b)

}
type A struct{
	a int
	b string
}

type B struct{
	int
	//int  匿名只能有一个
	string
}
//func (*A) newA(a int,b string,c [4]int){
//	return A(a,b,c)
//}

func test4(){
	var m map[string] int = make(map[string] int)
	m["a"]=1
	m["b"]=2
	fmt.Println(m)

	var a int=m["a"]
	fmt.Println(a)
	b , ok :=m["b"]
	fmt.Println(b)
	fmt.Println(ok)
}

func test3(){
	var a = []int{1,2,3,4}//[]为数组切片的定义[数字]为数组定义,切片按引用传递,数组按值传递
	fmt.Println(a)
	fmt.Println(a[2])
	a11 :=append(a,200,4555,4747)//生成新的实例,原始实例不变
	fmt.Println(a)
	fmt.Println(a11)


	var b = [][]int{{1,2,3},{1,2},{1}}//切片
	fmt.Println(b)

	fmt.Println(b[1][1])
	//fmt.Println(b[1][2]) index out

	for i,v:= range a{
		fmt.Printf("%d:%d\n",i,v)
	}

	forArray(b)//引用传递
	x:=b
	x[1][1]=23
	fmt.Println(x)
	fmt.Println(b)


	var y =[4]int{1,2,3,4}
	x1 := y
	x1[1] = 10000
	fmt.Println(x1)
	forArray2(y)//值传递
	fmt.Println(y)

	a1 := make([]int,5,6)//返回实例  数组类型,数组大小,数组容量
	fmt.Println(a1)
	fmt.Println(len(a1))
	fmt.Println(cap(a1))


	a2 := new([]int)//返回引用
	//a2[2] = 3
	fmt.Println(a2)
}

//切片
func forArray(array [][]int){
	array[2][0] = 3100
	fmt.Println(array)
}

//数组
func forArray2(array [4]int){
	array[2] = 10000
	fmt.Println(array)
}


func test2(){
	var s = "string"
	fmt.Println(s)
	var b = "bbbb"
	fmt.Println(s+b)

	c:=s[3]
	fmt.Println(c)
	d:=s[0]
	fmt.Println(d)

	for i := 0; i<len(s);i++  {
		fmt.Print(string(s[i])+",")
	}
}

func test1() {
	var i8 int8 = 30
	var i16 int16 = 4
	var i32 int = 5
	var i int = 5
	var i64 int64 = 6
	var b byte = 100

	var x = i32 == i
	fmt.Println(x)
	fmt.Println(i8)
	fmt.Println(i16)
	fmt.Println(i32)
	fmt.Println(i64)
	fmt.Println(b)
}
