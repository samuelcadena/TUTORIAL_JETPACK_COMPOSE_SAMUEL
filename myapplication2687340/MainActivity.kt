package com.example.myapplication2687340

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.myapplication2687340.ui.theme.MyApplication2687340Theme
import androidx.compose.foundation.border
import androidx.compose.material3.MaterialTheme
import android.content.res.Configuration
import android.provider.Telephony.Sms.Conversations
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            MyApplication2687340Theme{

                Conversation(SampleData.conversationSample)



                /*Surface(modifier = Modifier.fillMaxSize()) {


                    MessageCard(Message("Android", "Jetpack Compose"))



                }*/
            }

            //Text("Hello, Mateo And How Are They?")

            //MessageCard(name = "Android")


        }
    }
}



data class Message(val author: String, val body: String)


@Composable
fun MessageCard(msg: com.example.myapplication2687340.Message) {
    // Add padding around our message
    Row (modifier = Modifier.padding(all = 8.dp)){

        Image(
            painter = painterResource(R.drawable.aj19e3054),
            contentDescription = null,
            modifier = Modifier
                // Set image size to 40 dp
                .size(40.dp)
                // Clip image to be shaped as a circle
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
        )

        // Add a horizontal space between the image and the column
        Spacer(modifier = Modifier.width(8.dp))
        // We keep track if the message is expanded or not in this
        // variable

        var isExpanded by remember { mutableStateOf(false) }
        // surfaceColor will be updated gradually from one color to the other
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
        )

        // We toggle the isExpanded variable when we click on this column


        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }){

            Text(
                text = msg.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall
            )

            // Add a vertical space between the author and message texts
            Spacer(modifier = Modifier.height(4.dp))

            Surface(
                shape = MaterialTheme.shapes.medium,
                shadowElevation = 1.dp,
                // surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor,
                // animateContentSize will change the Surface size gradually

                ) {

                Text(
                    text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodySmall


                )
            }

            Text(
                text = msg.body,
                style = MaterialTheme.typography.bodySmall
            )

    }

    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"

)
@Composable
fun PreviewMessageCard(){
    MyApplication2687340Theme{
        Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp){
            MessageCard(
                msg = Message("Colleague", "Hey, take a look at Jetpack Compose, it's great!")
    )
        }
    }
}


@Composable
fun Conversation(messages: List<Message>){
    LazyColumn {

        items(messages) { message ->
            MessageCard(message)


        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    MyApplication2687340Theme {
        Conversation(SampleData.conversationSample)
    }

}


/*@Composable
fun MessageCard(name: String) {
    
    Text(text = "Hello $name")
}

@Preview
@Composable
fun PreviewMessageCard(){
    
    MessageCard(name = "Android")

}
 */





