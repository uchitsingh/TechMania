package com.tdd.uchit.techmania.ui.dialog

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.tdd.uchit.techmania.R
import com.tdd.uchit.techmania.data.model.Post
import kotlinx.android.synthetic.main.dialog_post_description.*
import kotlinx.android.synthetic.main.dialog_post_description.view.*

class PostDescriptionDialog : DialogFragment() {
    companion object {
        const val ARG_POST = "post_arg"
        fun instance(post: Post): PostDescriptionDialog {
            val postDescriptionDialog = PostDescriptionDialog()
            val arguments = Bundle()
            arguments.putParcelable(ARG_POST, post)
            postDescriptionDialog.arguments = arguments
            return postDescriptionDialog
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_post_description, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val post = arguments?.getParcelable<Post>(ARG_POST)
        post?.apply {
            val render = this.description.rendered
            view.description_tv.text = Html.fromHtml(render).toString()
        }
        ok_btn.setOnClickListener { dismiss() }
    }
}
