package jyqqhw.com.recyclerviewtest;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class CheckAnimRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

	private List<String> mData;
	private Context mContext;

	public CheckAnimRecyclerAdapter(List<String> mData, Context context) {
		this.mData = mData;
		this.mContext = context;
	}

	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		//根据数据创建右边的操作view
//		SwipeMenuView menuView = swipeMenuBuilder.create();
		//包装用户的item布局
//		SwipeMenuLayout2 swipeMenuLayout = SwapWrapperUtils.wrap(parent, R.layout.recycler_holder_item_with_check, menuView, new LinearInterpolator(), new LinearInterpolator());
		RelativeLayout linearLayout = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.recycler_holder_item_with_check, null);
		MyHolder holder = new MyHolder(linearLayout);
//		setListener(parent, holder, viewType);
		Log.e("wj", "create view holder? error!!!!!!!");
		return holder;
	}

	@Override
	public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
		MyHolder viewHolder = (MyHolder) holder;
		viewHolder.button.setText("我是按钮 " + position + " 号");
		Log.w("wj", "on binder view holder? yes!!!!!!!");

//		viewHolder.textView.setText("123456");
//		viewHolder.imageView.setImageResource(R.drawable.defaut_diu);

		Log.i("wj", "before  textView=" + viewHolder.textView.getText());
		Log.i("wj", "before  imageView=" + viewHolder.imageView.hashCode() + ", textView=" + viewHolder.textView.hashCode());

		viewHolder.imageView.setImageResource(R.drawable.defaut);
//		viewHolder.textView.setText(mData.get(position).toString());

		ImageTask imageTask = new ImageTask(viewHolder.imageView);
		imageTask.execute();
	}

	class ImageTask extends AsyncTask<Void, Void, Void> {

		private ImageView imageView;
		private TextView textView;

		public ImageTask(ImageView image) {
			imageView = image;
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
//			imageView.setImageResource(R.mipmap.ic_launcher);
		}

		@Override
		protected Void doInBackground(Void... params) {
			Log.i("wj", "middle  imageView=" + imageView.hashCode() + ", textView=");
//			try {
//				Thread.sleep(40);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			return null;
		}

		@Override
		protected void onPostExecute(Void aVoid) {
			super.onPostExecute(aVoid);
			imageView.setImageResource(R.mipmap.ic_launcher);
			Log.i("wj", "post execute..");
		}
	}

	@Override
	public int getItemCount() {
		return mData.size();
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	class MyHolder extends RecyclerView.ViewHolder {

		public TextView textView;
		public Button button;
		public ImageView imageView;

		public MyHolder(View itemView) {
			super(itemView);
			textView = (TextView) itemView.findViewById(R.id.id_tv);
			button = (Button) itemView.findViewById(R.id.btn_recycler_item);
			imageView = (ImageView) itemView.findViewById(R.id.id_image);
		}
	}

}
