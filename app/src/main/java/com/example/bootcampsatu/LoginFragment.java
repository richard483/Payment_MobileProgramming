package com.example.bootcampsatu;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginFragment extends Fragment {

    private FirebaseAuth auth;
    TextView createAccountText;
    View.OnClickListener toRegister = view -> getParentFragmentManager().beginTransaction().replace(R.id.frame_container, new RegisterFragment())
            .addToBackStack(null).commit();
    Button login;

    String email, password;
    EditText emailEt, passwordEt;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        emailEt = view.findViewById(R.id.login_email_et);
        passwordEt = view.findViewById(R.id.login_password_et);

        createAccountText = view.findViewById(R.id.create_account_text);
        createAccountText.setOnClickListener(toRegister);
        auth = FirebaseAuth.getInstance();
        login = view.findViewById(R.id.login_button);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = emailEt.getText().toString();
                password = passwordEt.getText().toString();
                auth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(requireActivity(), new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(requireActivity(), "Register Success", Toast.LENGTH_SHORT).show();
                                    Intent toMain = new Intent(requireActivity(), MainActivity.class);
                                    startActivity(toMain);
                                }else{
                                    Toast.makeText(requireActivity(), "Register unsuccessfull", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });
    }
}