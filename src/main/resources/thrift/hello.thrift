namespace java com.micmiu.thrift.demo

struct Person {
	1:i64 id,
	2:i32 age
}

service  HelloWorldService {
  string sayHello(1:string username, 2:Person person)
}