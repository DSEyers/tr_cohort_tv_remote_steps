# Tech Exercises - Pairing

##Duration

1 hour

##Submission Process

You’ll be paired up with another individual in the assessment process.

Working together over Zoom, you’ll be assigned a Zoom Breakout room to work through a coding problem (sometimes known as a coding kata)
together.

During the session, one of the Tech Returners tech coaches will join you in your virtual zoom room and see how things are going, if you need any
guidance.

One individual in the pair will record the session and the recording will be saved to that persons laptop.

Once the session ends you’ll have a recording of your pairing and you can then upload that recording using the following link:

https://forms.gle/BKjoARSn8fM4vNd5A

##Instructions and Tips

* Don’t forget to hit that record button before starting to work through the exercise
* The problem solving aspect and how you work together is the focus of this exercise
* Getting a functioning end outcome is a happy conclusion
* Again, you can choose whichever programming language you like to solve the solution. In your pair discuss which language to use, its ok if you choose a language that one of you hasn’t done before - you can still problem solve and discuss.
* There are various ways to pair together - here are some of the example approaches to pairing https://stackify.com/pair-programming-styles/

#Exercise
##Background

My TV remote control has arrow buttons and an OK button.

I can use these to move a "cursor" on a logical screen keyboard to type "words"...

The screen "keyboard" layout looks like this

```
a b c d e 1 2 3
f g h i j 4 5 6
k l m n o 7 8 9
p q r s t . @ 0
u v w x y z _ /
```
Write code that works out how many button presses on my remote are required to type a given word?

## Notes

* The cursor always starts on the letter a (top left)
* Remember to also press OK to "accept" each character.
* Take a direct route from one character to the next
* The cursor does not wrap (e.g. you cannot leave one edge and reappear on the opposite edge)
* A "word" (for the purpose of this exercise) is any sequence of characters available on my virtual "keyboard"

##Example

word = code

c => a-b-c-OK = 3

o => c-d-e-j-o-OK = 5

d => o-j-e-d-OK = 4

- e => d-e-OK =
- Answer = 3 + 5 + 4 + 2 =14
