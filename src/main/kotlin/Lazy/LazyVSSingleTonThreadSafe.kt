package Lazy

import javax.naming.Context

// https://medium.com/@kiitvishal89/kotlin-lazy-know-them-inside-out-94ab4de1676d

// Consider this class as heavy class
/*

Sometimes we encounter a scenario where we want to avoid initializations of some fields in a class till they are actually needed. A classic example could be, the case of heavy singletons. Why do you want to initialize your database manager class before you do any DB operations in your application? In mobile applications, the lazy loading of heavy classes gives you a performance edge as it improves the app load time. App loads whatever is required bare minimum to present the screen to the user.

We are familiar with the approach of lazy loading in the double-checked locking techniques in the Singleton pattern in Java. Let us see how it looks like.

public class MockManager {
    private static volatile MockManager _instance = null;

    private MockManager(String arg1,int arg2) {
        // code to create the MockManager.
    }

    public static MockManager instance(String arg1,int arg2) {
        if(_instance == null) {
            synchronized (MockManager.class) {
                if(_instance == null) {
                    // Create instance. Using custom logic.
                    _instance = new MockManager(arg1,arg2);
                }
            }
        }
        return _instance;
    }
}
This class does a couple of things.

Does the initialization of the MockManager once, and the next time user calls it, it returns the stored instance from the memory.
It takes care of synchronization issues, even if multiple threads call instance() to create mockmanager, only one thread gets the chance to create it and rest use the stored instance.
The instance is created when you actually use the class ie lazily created.
But the question is, can we this for all classes in which we want to implement these properties. It would be too tedious and a lot of code. Here kotlin’s lazy delegates shine.

Let’s see how this functionality, when implemented through lazy, would look like.




class TestClass {
    val mockManager1 by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        // argument to lazy is optional and LazyThreadSafetyMode.SYNCHRONIZED
        // is the default argument too
        MockManager1("argument1",0)
    }
}


public class MockManager {
    public MockManager1(String arg1,int arg2) {
        // code to create the MockManager.
    }
}

The code is minimal. But it comes with some drawbacks.

The first access to mockmanager is synchronized, if you do not have concurrency in your code, that will add an additional cost which is unnecessary.
If you try to synchronize the code with returned instance ie. mockmanager externally it might result in deadlock. If thread encounters an exception, while creating the instance, the kotin framework safely releases the lock. We will deal with the internal details in the next post. If we want to provide any external lock object we can very well do that like this, but be wary of the consequences:

class TestClass {
  val lock = Any()
  val mockManager by lazy(lock) {
       // Now lazy will lock on the exteranl lock object provided.
        MockManager("argument1",0)
  }
}


public class MockManager {
    public MockManager(String arg1,int arg2) {
        // code to create the MockManager.
    }
}

So now we know, that we should not be filling our code with lazy delegates otherwise, it is going to add synchronization in places where there is no concurrency at all. So what is the solution to that?

class Test {
  // We just want to do lazy loading without any synchronization
val listOfStudents by lazy(LazyThreadSafetyMode.NONE) {
            val internalList = mutableListOf<Student>()
            for(i in 1..100) {
                internalList.add(Student("A + $i",i))
            }
        internalList
    }
}

When you use the mode NONE, be very sure that you do not have multiple threads competing to initialize the value, otherwise results will be unpredictable!

In the context of android, I see lots of variables that I have to initialize eagerly in the lifecycle callbacks, which can be deferred to the point where it is first accessed. Lazy.NONE is a good choice for those cases. Given we are executing on MainThread.

There are 3 such modes possible:

1. LazyThreadSafetyMode.SYNCHRONIZED (thread-safe)
2. LazyThreadSafetyMode.PUBLICATION  (thread-safe)
3. LazyThreadSafetyMode.NONE         (non thread-safe)
We have already talked about 1 and 3, now let’s talk about Publication mode.

In the case of mode Synchronized, multiple threads are not allowed to run the initializer lambda, only one thread is allowed inside the monitor, it executes the initializer and other threads use the stored value. Contrary to that, there is no such restriction there in Publication, multiple threads are allowed to run the initializer lambda but the first one to create the instance wins, and that value is published as used by other threads. This mode is also thread-safe. So, confused? When to use Synchronized and when to use Publication?

Both the modes provide thread safety, but in case of publication, the initializer is run more than once till the value gets initialized after that the same stored value is returned. If you feel that running your calculation in multiple threads simultaneously might eat up processor resources due to the nature of your initializer then go for synchronized, else if code is on the lighter side publication can give you thread safety without the cost of locking.

One thing to note is the kotlin initializer functions provided as lamdas are represented as anonymous inner classes and capture the outer scope and are released once the instance is created. If your initializer function does something heavy and time consuming, then take care of memory leaks also. It could leak memory!

Kotlin lambdas do not get benefits of java’s InvokeDynamic call which java lambdas take.

INVOKESPECIAL HandleKt$main$listOfStudents$2.<init> (LStudent;)V
CHECKCAST kotlin/jvm/functions/Function0
INVOKESTATIC kotlin/LazyKt.lazy (Lkotlin/LazyThreadSafetyMode;Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
So, how can we do all these things in Java? Can we do something about it? We will get to know the answer to all these questions in the below post.

https://medium.com/@kiitvishal89/implementing-kotlin-lazy-like-functionality-in-java-8b23185ba1f7

*/

// https://blog.logrocket.com/initializing-lazy-lateinit-variables-kotlin/
fun main(){
    val pi = lazy {
        3.14f
    }

    println("Is `pi` initialized? ${pi.isInitialized()}")
    println("The value of `pi`: ${pi.value}")


    // Using by

    val area = Area()


    val squareSideLength = 51

    println("Area of our rectangle is ${area.rectangle(squareSideLength)}")

}

class Area {
    val pi by lazy {3.14f}

    fun circle(radius: Int): Float = pi * radius * radius
    fun rectangle(length: Int, breadth: Int = length): Int = length * breadth
    fun triangle(base: Int, height: Int): Float = base * height * .5f
}

// Note that this doesn't guarantee calls on it thread-safe, but that's just as in Java.
object Singleton {
    // any members you need
}


class SingletonObj {
    private constructor(context: Context)

    companion object {
        @Volatile private var mInstance: SingletonObj? = null

        public  fun get(context: Context): SingletonObj =
            mInstance ?: synchronized(this) {
                val newInstance = mInstance ?: SingletonObj(context).also { mInstance = it }
                newInstance
            }
    }
}
//Thread-safe and lazy:

class Singleton2 private constructor() {
    companion object {
        val instance: Singleton2 by lazy { Singleton2() }
    }
}
//Double null check already implemented inside by lazy.

