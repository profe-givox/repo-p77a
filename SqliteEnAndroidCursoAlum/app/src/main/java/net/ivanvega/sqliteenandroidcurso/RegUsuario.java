package net.ivanvega.sqliteenandroidcurso;

import net.ivanvega.sqliteenandroidcurso.datos.UsuariosDAO;
import net.ivanvega.sqliteenandroidcurso.modelo.Usuario;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegUsuario extends Activity implements OnClickListener {
	EditText txtN, txtE, txtC;
	TextView lblID;
	Button btnG,btnC;
	Intent intentAccion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_reg_usuario);
		
		lblID = (TextView)findViewById(R.id.lblID);
		
		txtN = (EditText)findViewById(R.id.txtNombre);
		txtE = (EditText)findViewById(R.id.txtEmail);
		txtC = (EditText)findViewById(R.id.txtPass);
		
		btnG = (Button)findViewById(R.id.btnGuardar); btnG.setOnClickListener(this);
		btnC = (Button)findViewById(R.id.btnCancelar);btnC.setOnClickListener(this);
		
		intentAccion =  getIntent();
		personalizarAccion(intentAccion.getStringExtra("accion"));
	}
	
	public void personalizarAccion(String  accion) {
		btnC.setText("Cancelar");
		if (accion.equals("insert")){
			this.setTitle("Registrar Usuario");
			btnG.setText("Guardar");
		}
		
		if (accion.equals("edit")){
			this.setTitle("Editar Usuario");
			btnG.setText("Actualizar");
			cargarUsuario(intentAccion.getIntExtra("id", 0));
		}
	}
	
	private void cargarUsuario(int id) {
		UsuariosDAO dao = new UsuariosDAO(getApplicationContext());
		Usuario usuario;
		
		try {
			usuario = dao.getOneByID(id);
			if(usuario!=null){
				lblID.setText(String.valueOf( usuario.getId()));
				txtN.setText(String.valueOf( usuario.getNombre()));
				txtE.setText(String.valueOf( usuario.getEmail()));
				txtC.setText(String.valueOf( usuario.getContrasenia()));
			}else{
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("CARGAR_USUARIO", e.getMessage());
		}
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.reg_usuario, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.equals(btnG)){
			if(intentAccion.getStringExtra("accion").equals("insert")){
				insert();
			}else{
				update();
			}
		}
		
		if (v.equals(btnC)){
			finish();
		}
	}
	
	private void update() {
		Usuario usuario =
				new Usuario(
						Integer.parseInt( lblID.getText().toString()),
						txtN.getText().toString(),
						txtE.getText().toString(), 
						txtC.getText().toString());
		UsuariosDAO dao = new UsuariosDAO(getApplicationContext());
		try {
			if( dao.update(usuario)){
				Toast.makeText(getBaseContext(), "USUARIO EDITADO",
						Toast.LENGTH_LONG).show();
				setResult(RESULT_OK, null);
				finish();
			}else {
				Toast.makeText(getBaseContext(), "FALLO EDITAR USUARIO",
						Toast.LENGTH_LONG).show();
				setResult(RESULT_CANCELED, null);
				finish();
			}
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("UPDATE",e.getMessage());
			finish();
		}
	}	
	
	private void insert() {
		Usuario usuario =
				new Usuario(
						0, txtN.getText().toString(),
						txtE.getText().toString(), 
						txtC.getText().toString());
		UsuariosDAO dao = new UsuariosDAO(getApplicationContext());
		try {
			if( dao.insert(usuario)){
				Toast.makeText(getBaseContext(), "USUARIO INSERTADO",
						Toast.LENGTH_LONG).show();
				setResult(RESULT_OK, null);
				finish();
			}else {
				Toast.makeText(getBaseContext(), "FALLO INSERTAR USUARIO",
						Toast.LENGTH_LONG).show();
				setResult(RESULT_CANCELED, null);
				finish();
			}
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("INSERT",e.getMessage());
			finish();
		}
	}

}
