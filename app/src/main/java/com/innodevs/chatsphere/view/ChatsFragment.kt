package com.innodevs.chatsphere.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.innodevs.chatsphere.R
import com.innodevs.chatsphere.adapter.ChatAdapter
import com.innodevs.chatsphere.model.UserChat
import com.innodevs.chatsphere.viewmodel.ChatViewModel
import com.innodevs.chatsphere.viewmodel.ChatViewModelFactory

class ChatsFragment : Fragment(R.layout.fragment_chats) {
    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var chatAdapter: ChatAdapter
    private lateinit var chatViewModel: ChatViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chats, container, false)

        // RecyclerView setup
        chatRecyclerView = view.findViewById(R.id.chatRecyclerView)
        chatRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Dummy chat data
        /*val chatList = listOf(
            UserChat("1",  "+123456789", R.drawable.profile_pic1, "Hey, how are you?"),
            UserChat("2",  "+987654321", R.drawable.profile_pic1, "Let's meet tomorrow."),
            UserChat("3",  "+5647382910", R.drawable.profile_pic1, "See you soon!"),
            UserChat("4",  "+1122334455", R.drawable.profile_pic1, "Are you available?")
        )*/
        // Create ViewModel instance
        // Use ViewModelFactory to create ViewModel
        val factory = ChatViewModelFactory(requireContext())
        chatViewModel = ViewModelProvider(this, factory).get(ChatViewModel::class.java)

        // Observe LiveData from ViewModel and update the adapter
        chatViewModel.chatData.observe(viewLifecycleOwner, { chatList ->
            chatAdapter = ChatAdapter(chatList)
            chatRecyclerView.adapter = chatAdapter
        })

        return view
    }

       /* chatAdapter = ChatAdapter(chatList)
        chatRecyclerView.adapter = chatAdapter*/

       // return view


    override fun onDestroyView() {
        super.onDestroyView()
        // Disconnect from the socket when the fragment is destroyed
        chatViewModel.disconnectSocket()
    }
}
