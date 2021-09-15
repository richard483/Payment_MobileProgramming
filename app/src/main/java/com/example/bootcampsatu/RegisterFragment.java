package com.example.bootcampsatu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterFragment extends Fragment {

    ImageView backBtn;
    Button register;
    String emailString, passwordString;
    EditText emailEt, passwordEt;

    View.OnClickListener back = view -> getParentFragmentManager().popBackStack();
    private FirebaseAuth auth;
    View.OnClickListener signup = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            emailString = emailEt.getText().toString();
            passwordString = passwordEt.getText().toString();
           auth.createUserWithEmailAndPassword(emailString, passwordString)
                    .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(requireActivity(), "Register Success", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(requireActivity(), "Register unsuccessfull", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        backBtn = view.findViewById(R.id.back_btn);

        backBtn.setOnClickListener(back);

        auth = FirebaseAuth.getInstance();
        register = view.findViewById(R.id.register_button);
        emailEt = view.findViewById(R.id.email_et);
        passwordEt = view.findViewById(R.id.password_et);

        register.setOnClickListener(signup);

    }
}