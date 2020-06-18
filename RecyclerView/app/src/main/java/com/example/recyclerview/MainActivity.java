package com.example.recyclerview;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.content.Context;
        import android.content.pm.ApplicationInfo;
        import android.content.pm.PackageManager;
        import android.graphics.drawable.Drawable;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.ViewGroup;

        import com.example.recyclerview.databinding.ActivityMainBinding;
        import com.example.recyclerview.databinding.ItemBinding;

        import java.util.ArrayList;
        import java.util.List;


class Apps{
    String mLabel;
    Drawable  mIcon;
    String mPackageName;

    Apps(String label, Drawable icon, String packageName){
        mLabel=label;
        mIcon=icon;
        mPackageName=packageName;
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{
    public ItemBinding itemBinding;
    MyViewHolder(ItemBinding binding){
        super(binding.getRoot());
        itemBinding=binding;
    }
}

class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{

    private List<Apps> mApps;
    MyAdapter(List<Apps> apps){
        mApps=apps;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        ItemBinding itemBinding=ItemBinding.inflate(inflater,parent,false);
        return new MyViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Apps app=mApps.get(position);
        holder.itemBinding.img.setImageDrawable(app.mIcon);
        holder.itemBinding.label.setText(app.mLabel);
        holder.itemBinding.packageName.setText(app.mPackageName);
    }

    @Override
    public int getItemCount() {
        return mApps.size();
    }
}

public class MainActivity extends AppCompatActivity {

    ArrayList mApps =new ArrayList<Apps>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        final PackageManager pm= getPackageManager();
        List<ApplicationInfo> packages= pm.getInstalledApplications(PackageManager.GET_META_DATA);
        for(int i=0; i<packages.size(); i++) {
            ApplicationInfo appInfo = packages.get(i);
            CharSequence label=appInfo.loadLabel(pm);
            String label2=label.toString();
            Drawable icon=appInfo.loadIcon(pm);
            String packageName=appInfo.packageName;
            mApps.add(new Apps(label2,icon,packageName));
        }

        binding.recyclerview.setAdapter(new MyAdapter(mApps));
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}
