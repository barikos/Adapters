package com.minutes111.adapters.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.minutes111.adapters.Const;
import com.minutes111.adapters.R;
import com.minutes111.adapters.model.Book;

/**
 * Created by barikos on 27.04.16.
 */
public class AddBookDialogFragment extends DialogFragment{
    private EditText mEditTextName;
    private EditText mEditTextAuth;



    OnBookAddListener mBookAddListener;

    public AddBookDialogFragment() {
    }

    public interface OnBookAddListener{
        void createNewBook(Book book);
    }

    public static AddBookDialogFragment newInstance(String title){
        AddBookDialogFragment frag = new AddBookDialogFragment();
        Bundle args = new Bundle();
        args.putString(Const.FRAG_TITLE, title);
        frag.setArguments(args);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_book_add,container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEditTextName = (EditText)view.findViewById(R.id.edit_frag_name);
        mEditTextAuth = (EditText)view.findViewById(R.id.edit_frag_auth);

        String title = getArguments().getString(Const.FRAG_TITLE,"Enter data");
        getDialog().setTitle(title);
        mEditTextName.requestFocus();
    }
}
