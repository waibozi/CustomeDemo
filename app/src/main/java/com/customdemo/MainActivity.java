package com.customdemo;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_grid);
        int[] res = {R.mipmap.t1, R.mipmap.t2, R.mipmap.t3, R.mipmap.t4, R.mipmap.t5, R.mipmap.t6};
        recyclerView.setAdapter(new MyAdapter(res));
    }

    private static class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private int[] res;

        public MyAdapter(int[] res) {
            this.res = res;
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final MyAdapter.ViewHolder holder, int position) {
            holder.iv_image.setImageResource(res[position]);
            Palette.Builder palette = new Palette.Builder(BitmapFactory.decodeResource(holder.iv_image.getResources(), res[position]));
            palette.generate(new Palette.PaletteAsyncListener() {
                @Override
                public void onGenerated(Palette palette) {
                    Palette.Swatch swatch = palette.getLightVibrantSwatch();
                    if (swatch != null) {
                        int rgb = swatch.getRgb();
                        holder.tv_label.setTextColor(swatch.getTitleTextColor());
                        int red = Color.red(rgb);
                        int green = Color.green(rgb);
                        int blue = Color.blue(rgb);
                        int alpha = Color.alpha(rgb);
                        alpha = Math.round(alpha * 0.8f);
                        Log.e("tag", alpha + "");
                        int color = Color.argb(alpha, red, green, blue);
                        holder.tv_label.setBackgroundColor(color);
                    } else {
                        holder.tv_label.setBackgroundColor(palette.getLightVibrantColor(Color.GREEN));
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return res.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView iv_image;
            TextView tv_label;

            public ViewHolder(View itemView) {
                super(itemView);
                iv_image = (ImageView) itemView.findViewById(R.id.iv_image);
                tv_label = (TextView) itemView.findViewById(R.id.tv_label);
            }
        }
    }
}
