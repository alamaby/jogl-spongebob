package com.workingbinary;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;


/**
 * GLRenderer.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class GLRenderer implements GLEventListener {

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!
        
            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLUT glut = new GLUT();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();

        // Move the "drawing cursor" around
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);

        //kepala
        gl.glPushMatrix();//save current matrix
        gl.glScalef(1.0f, 1.0f, 0.4f); //untuk mengubah ukuran benda
        glut.glutWireCube(1.0f);//wireframe kubus dengan ukuran 1
        gl.glPopMatrix();//pop biar reset
        //baju
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -0.58f, 0.0f);//mentranslate titik koordinat start
        gl.glScalef(1.0f, 0.15f, 0.4f);
        gl.glColor3d(1.0, 1.0, 1.0);
        glut.glutWireCube(1.0f);
        gl.glPopMatrix();
        //celana
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -0.73f, 0.0f);// -0.58-0.15=-0.73
        gl.glScalef(1.0f, 0.15f, 0.4f);
        gl.glColor3d(1.0, 0.0, 0.0);
        glut.glutWireCube(1.0f);
        gl.glPopMatrix();
        //celana kiri
        gl.glPushMatrix();
        gl.glTranslatef(-0.2f, -0.84f, 0.0f);// -0.73-0.15=-0.88
        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
        gl.glColor3d(1.0, 0.0, 0.0);
        glut.glutWireCylinder(0.1, 0.05, 10, 10);
        gl.glPopMatrix();
        //celanan kanan
        gl.glPushMatrix();
        gl.glTranslatef(0.2f, -0.84f, 0.0f);// -0.73-0.15=-0.88
        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
        gl.glColor3d(1.0, 0.0, 0.0);
        glut.glutWireCylinder(0.1, 0.05, 10, 10);
        gl.glPopMatrix();
        //kaki kiri
        gl.glPushMatrix();
        gl.glTranslatef(-0.2f, -0.84f, 0.0f);// -0.73-0.15=-0.88
        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
        gl.glColor3d(1.0, 1.0, 0.0);
        glut.glutWireCylinder(0.02, 0.5, 5, 5);
        gl.glPopMatrix();
        //kakikanan
        gl.glPushMatrix();
        gl.glTranslatef(0.2f, -0.84f, 0.0f);// -0.73-0.15=-0.88
        gl.glRotatef(90, 1.0f, 0.0f, 0.0f);
        gl.glColor3d(1.0, 1.0, 0.0);
        glut.glutWireCylinder(0.02, 0.5, 5, 5);
        gl.glPopMatrix();
        //lengan baju kiri
        gl.glPushMatrix();
        gl.glTranslatef(-0.5f, -0.2f, 0.0f);
        gl.glRotatef(90, 0.0f, -1.0f, 0.0f);
        gl.glColor3d(1.0, 1.0, 1.0);
        glut.glutWireCone(0.1, 0.3, 10, 10);
        gl.glPopMatrix();
        //lengan baju kanan
        gl.glPushMatrix();
        gl.glTranslatef(0.5f, -0.2f, 0.0f);
        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
        gl.glColor3d(1.0, 1.0, 1.0);
        glut.glutWireCone(0.1, 0.3, 10, 10);
        gl.glPopMatrix();
        //lengan kiri
        gl.glPushMatrix();
        gl.glTranslatef(-0.5f, -0.2f, 0.0f);
        gl.glRotatef(90, 0.0f, -1.0f, 0.0f);
        gl.glColor3d(1.0, 1.0, 0.0);
        glut.glutWireCylinder(0.02, 1, 5, 5);
        gl.glPopMatrix();
        //lengan kanan
        gl.glPushMatrix();
        gl.glTranslatef(0.5f, -0.2f, 0.0f);
        gl.glRotatef(90, 0.0f, 1.0f, 0.0f);
        gl.glColor3d(1.0, 1.0, 0.0);
        glut.glutWireCylinder(0.02, 1, 5, 5);
        gl.glPopMatrix();
        //mata kiri
        gl.glPushMatrix();
        gl.glTranslatef(-0.2f, 0.0f, 0.2f);
        gl.glScalef(1.0f, 1.0f, 0.4f);
        gl.glColor3d(0.5, 0.7, 1.0);
        glut.glutWireSphere(0.2, 10, 10);
        gl.glPopMatrix();
        //mata kanan
        gl.glPushMatrix();
        gl.glTranslatef(0.2f, 0.0f, 0.2f);
        gl.glScalef(1.0f, 1.0f, 0.4f);
        gl.glColor3d(0.5, 0.7, 1.0);
        glut.glutWireSphere(0.2, 10, 10);
        gl.glPopMatrix();
        //hidung
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -0.15f, 0.26f);
        gl.glScalef(1.0f, 1.0f, 1.5f);
        gl.glColor3d(1.0, 1.0, 0.0);
        glut.glutWireSphere(0.06, 10, 10);
        gl.glPopMatrix();
        //mulut
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -0.35f, 0.2f);
        gl.glScalef(3.5f, 1.0f, 0.0f);
        gl.glColor3d(1.0, 0.0, 0.0);
        glut.glutWireSphere(0.06, 10, 10);
        gl.glPopMatrix();
        //gigi kiri
        gl.glPushMatrix();
        gl.glTranslatef(-0.04f, -0.34f, 0.2f);
        gl.glScalef(0.8f, 1.1f, 0.5f);
        gl.glColor3d(1.0, 1.0, 1.0);
        glut.glutWireCube(0.08f);
        gl.glPopMatrix();
        //gigi kanan
        gl.glPushMatrix();
        gl.glTranslatef(0.04f, -0.34f, 0.2f);
        gl.glScalef(0.8f, 1.1f, 0.5f);
        gl.glColor3d(1.0, 1.0, 1.0);
        glut.glutWireCube(0.08f);
        gl.glPopMatrix();

        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}

