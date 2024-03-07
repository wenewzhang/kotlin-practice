package com.example.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.example.myapplication2.ui.theme.MyApplication2Theme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplication2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MessageCard(Message("Androidsss", "here"))
                    Conversation(SampleData.conversationSample)
                }
            }
        }
    }
}

data class Message(val name:String, val title:String)

@Composable
fun MessageCard(msg: Message, modifier: Modifier = Modifier) {
    Row(modifier = Modifier.padding(all = 8.dp)){
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(
                text = "hello, ${msg.name}",
                modifier = modifier,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = msg.title,
                color = MaterialTheme.colorScheme.primary,
                modifier = modifier

            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplication2Theme {
        MessageCard(Message("Androidee","abc"))
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    MyApplication2Theme {
        Conversation(SampleData.conversationSample)
    }
}
