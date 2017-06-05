package ccc.android;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;  
import android.opengl.GLSurfaceView;
import javax.microedition.khronos.egl.EGLConfig;  
import javax.microedition.khronos.opengles.GL10;  

public class OpenGL1 extends Activity {
    
	  private GlView mGlView;  
	  
	  public void onCreate(Bundle savedInstanceState){  
	    super.onCreate(savedInstanceState);  
	    mGlView = new GlView(this);  
	    setContentView(mGlView);  
	  }  
}

class GlView extends GLSurfaceView{  
	  
	  private GlRender mGlRender;   
	  
	  public GlView(Context context){  
	    super(context);  
	      
	    mGlRender = new GlRender();  
	    setRenderer(mGlRender);  
	  }  
}  

class GlRender implements GLSurfaceView.Renderer{  
    
	  @Override  
	  public void onSurfaceCreated(GL10 gl,EGLConfig config){  
	    gl.glClearColor( 0.0f, 1.0f, 0.0f, 1.0f);// 3D背景色rgba
	  }  
	  
	  @Override  
	  public void onSurfaceChanged(GL10 gl,int w,int h){  
	    gl.glViewport( 0, 0, w, h );  
	    gl.glMatrixMode( GL10.GL_PROJECTION);  
	    gl.glLoadIdentity();
	    float ratio;  
	    ratio = (float)w/h;  
	    gl.glFrustumf(-ratio,ratio,-1,1,1,500);  
	  }  
	  
	  @Override  
	  public void onDrawFrame(GL10 gl){  
	    gl.glClear(GL10.GL_COLOR_BUFFER_BIT);  
	    gl.glMatrixMode(GL10.GL_MODELVIEW);  
	    gl.glLoadIdentity();  
	  }  
}  