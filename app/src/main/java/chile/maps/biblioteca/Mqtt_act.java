package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.api.Api;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Mqtt_act extends AppCompatActivity {
    static String MQTTHOST = "tcp://tailor.cloudmqtt.com:13900";
    static String USERNAME = "qmprhhyz";
    static String PASSWORD = "QPOvZaKgzNEQ";
    String topicStr = "Libros";
    MqttAndroidClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt_act);

        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getBaseContext(), MQTTHOST, clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(USERNAME);
        options.setPassword(PASSWORD.toCharArray());

        try {
            IMqttToken token = client.connect(options);
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    Toast.makeText(getBaseContext(),"CONEXION ESTABLECIDA", Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Toast.makeText(getBaseContext(),"CONEXION NO ESTABLECIDA", Toast.LENGTH_LONG).show();


                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void libro1(View v){
        String topic = topicStr;
        String message ="Farenheith";
        try{
            client.publish(topic, message.getBytes(),0 ,false);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void libro2(View v){
        String topic = topicStr;
        String message ="Revival";
        try{
            client.publish(topic, message.getBytes(),0 ,false);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void libro3(View v){
        String topic = topicStr;
        String message ="El Alquimista";
        try{
            client.publish(topic, message.getBytes(),0 ,false);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void libro4(View v){
        String topic = topicStr;
        String message ="El Poder";
        try{
            client.publish(topic, message.getBytes(),0 ,false);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void libro5(View v){
        String topic = topicStr;
        String message ="Despertar";
        try{
            client.publish(topic, message.getBytes(),0 ,false);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
