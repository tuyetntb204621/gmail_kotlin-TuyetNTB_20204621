import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.gmailkotlin.R
import kotlin.random.Random

class Email(var sender: String, val time: String, val content: String)

class EmailsAdaptor(private val emails: List<Email>) : BaseAdapter() {
    override fun getCount(): Int {
        return emails.size
    }

    override fun getItem(position: Int): Any {
        return emails[position]
    }

    override fun getItemId(position: Int): Long {
        return 1
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var emailView: View
        if (convertView == null) {
            emailView =
                LayoutInflater.from(parent?.context).inflate(R.layout.email_item, parent, false)
        } else {
            emailView = convertView
        }

        val email = emails[position]
        emailView.findViewById<TextView>(R.id.email_sender).text = email.sender
        emailView.findViewById<TextView>(R.id.email_time).text = email.time
        emailView.findViewById<TextView>(R.id.email_content).text = email.content


        val name_icon = emailView.findViewById<TextView>(R.id.circle_name)
        name_icon.text = email.sender[0].toString()
        val drawable = name_icon.background
        drawable.setColorFilter(-Random.nextInt(-Color.BLACK), PorterDuff.Mode.SRC)
        name_icon.background = drawable

        return emailView
    }
}