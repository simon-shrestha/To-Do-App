package com.example.todomvvm;


        import android.app.AlertDialog;
        import android.app.Dialog;
        import android.content.DialogInterface;
        import android.os.Bundle;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatDialogFragment;
        import androidx.fragment.app.Fragment;
        import androidx.lifecycle.ViewModelProviders;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.todomvvm.tasks.MainActivityViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlertFragment extends AppCompatDialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.activity_alert_layout,null);
        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener()
        {
            MainActivityViewModel viewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);;
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                switch (which)
                {
                    case DialogInterface.BUTTON_POSITIVE:
                        Toast.makeText(getActivity(), "Deleted all tasks", Toast.LENGTH_LONG).show();
                        viewModel.trunicateTask();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        Toast.makeText(getActivity(), "Cancelled deletion", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };

        return new AlertDialog.Builder(getActivity())
                .setTitle("Confirm Delete")
                .setView(view)
                .setPositiveButton(android.R.string.ok, listener)
                .setNegativeButton(android.R.string.cancel, listener)
                .create();
    }

}
