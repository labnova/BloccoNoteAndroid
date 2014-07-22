package com.labnova.blocconote;

import com.labnova.blocconote.data.NoteItem;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

public class NoteEditorActivity extends Activity {
	
	private NoteItem note;

	  @TargetApi(Build.VERSION_CODES.HONEYCOMB) protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_note_editor);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		Intent intent= this.getIntent();
		note= new NoteItem();
		note.setKey(intent.getStringExtra("key"));
		note.setText(intent.getStringExtra("text"));
		
		EditText et= (EditText) findViewById(R.id.noteText);
		et.setText(note.getText());
		et.setSelection(note.getText().length());
			
		
	}
	
	
	private void saveAndFinish() {
		EditText et= (EditText) findViewById(R.id.noteText);
		String noteText= et.getText().toString();
		
		Intent intent= new Intent();
		
		intent.putExtra("key", note.getKey());
		intent.putExtra("text", noteText);
		
		setResult(RESULT_OK, intent);
		finish();
		
		
	}
	
	private boolean onOptionItemSelected(MenuItem item) {
		
		if (item.getItemId()== android.R.id.home) {
			
			saveAndFinish();
			
		}
		
		return false;

	
	}
	
	@Override
	public void onBackPressed() {
		saveAndFinish();
	}
	
	
	
	
}
