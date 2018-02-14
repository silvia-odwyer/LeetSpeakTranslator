package com.silviaodwyer.leetspeaktranslator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.silviaodwyer.leetspeaktranslator.R

class MainActivity : AppCompatActivity() {
    private var outputMessage: TextView? = null
    private var translateButton: Button? = null
    private var userInput: EditText? = null
    private var advTranslateButton: Button? = null

    var messageToBeTranslated: String = ""
    val alphabetArray: Array<Any> = arrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '.', ',')

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userInput = findViewById(R.id.userInput)
        translateButton = findViewById(R.id.translateButton)
        outputMessage = findViewById(R.id.outputMessage)
        advTranslateButton = findViewById(R.id.advTranslateButton)

        fun advConvertToLeetSpeak(messageToBeTranslated: String, alphabetArray: Array<Any>): String {

            var messageTobeTranslated: String = messageToBeTranslated.toLowerCase()
            var outputMessage: String = ""
            val leetArray: Array<Any> = arrayOf("4", "8", "(", "|)", '3', "|=", "9", "|-|", "!", "_|", 'X', "1", "|\\//|", "|V", "0", "|*", "(_,)", "2", "5", "7", "(_)", "\\//", "\\//\\//", "><", "7", "2", ' ', '.', ',')
            var listOfMessage = messageToBeTranslated.toList()

            for (letter in listOfMessage) {
                var index_number = alphabetArray.indexOf(letter)
                println("$letter $index_number")
                var leetElement = leetArray[index_number]
                outputMessage += leetElement
            }

            outputMessage = outputMessage.toString()
            return outputMessage
        }

        fun convertToLeetSpeak(messageToBeTranslated: String): String {
            var outputMessage: String = ""
            val alphabetArray: Array<Any> = arrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '.', ',', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0')
            val leetArray: Array<Any> = arrayOf('4', 'b', 'c', 'd', '3', 'f', 'g', 'h', '1', 'j', 'k', 'l', 'm', 'n', '0', 'p', 'q', 'r', '5', '7', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '.', ',', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0')
            var condition: Int = 1
            val leetWordList: List<String> = listOf("1337", "1337", "h4xor", "n00b", "pwn", "j00", "kewl", "roxx0rs", "w00t", "w00t", "d00d")
            val englishWordList: List<String> = listOf("leet", "elite", "hacker", "newbie", "own", "you", "cool", "rocks", "woo", "yay", "dude")
            var leetSentenceb4Conversion: String = ""
            var splitString = messageToBeTranslated.split(" ")
            for (word1 in splitString){
                for (word2 in englishWordList){
                    if (word1 == word2) {
                        var wordIndex: Int = englishWordList.indexOf(word1)
                        var leetWord: String = leetWordList[wordIndex]
                        leetSentenceb4Conversion += (" $leetWord")
                        condition = 0

                    }
                }
                if (condition == 1){
                    leetSentenceb4Conversion += (" $word1")
                }
            }


            val messageArray = CharArray(10000)
            var listOfMessage = leetSentenceb4Conversion.toList()

//            for (letter in messageToBeTranslated) {
//                messageArray.set(index, letter)
//                listOfMessage += letter
//                index += 1
//                //println("$index $letter")
//            }


            for (letter in listOfMessage) {
                var index_number = alphabetArray.indexOf(letter)
                println("$letter $index_number")
                var leetElement = leetArray[index_number]
                println("$letter $leetElement")
                outputMessage += leetElement

            }
            println(outputMessage)
            outputMessage = outputMessage.toString()
            return outputMessage

        }

        translateButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                // Contents in the editText are saved in a variable
                //Log.d(TAG, "OnClick: called")
                val messageToBeTranslated = userInput?.text
                outputMessage?.movementMethod = ScrollingMovementMethod()
                outputMessage?.text = ""

                var stringOfMessage: String = messageToBeTranslated.toString()
                stringOfMessage = stringOfMessage.toLowerCase()

                outputMessage?.append("Your entered message is: $messageToBeTranslated")

                var leetTranslation: String = convertToLeetSpeak(stringOfMessage)

                outputMessage?.append("\nYour 1337 message is: $leetTranslation")
            }
        })


        advTranslateButton?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val messageToBeTranslated = userInput?.text
                outputMessage?.movementMethod = ScrollingMovementMethod()
                outputMessage?.text = ""

                var stringOfMessage: String = messageToBeTranslated.toString()
                stringOfMessage = stringOfMessage.toLowerCase()

                outputMessage?.append("Your entered message is: $messageToBeTranslated")
                var leetTranslation: String = advConvertToLeetSpeak(stringOfMessage, alphabetArray)

                outputMessage?.append("\n Your 1337 message is: $leetTranslation")
            }

        })

        userInput?.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                userInput?.setText("")
            }
        })
    }
}
