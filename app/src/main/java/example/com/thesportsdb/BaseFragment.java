package example.com.thesportsdb;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import example.com.thesportsdb.view.activity.MainActivity;

public class BaseFragment extends Fragment {
    protected MainActivity parentActivity;
    protected Context context;

    public BaseFragment(){
        //empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        parentActivity = (MainActivity) getActivity();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach( context );
        this.context = context;
    }
}
