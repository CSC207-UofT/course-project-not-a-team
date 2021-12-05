package com.farmgame.frontEnd.main;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.farmgame.R;

import java.util.Objects;

/***
 * the dialog for buying an object
 */
public class BuyDialog extends AlertDialog {

    TextView quantityView;


    /***
     *
     * @param context context of the dialog
     */
    protected BuyDialog(@NonNull Context context) {
        super(context);
    }

    /***
     * override the onCreate function
     * set listeners
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buy_dialog);

        quantityView = findViewById(R.id.quantity);

        setListeners();

    }



    /***
     * set the confirm button listener
     * @param listener the onclickListener to be set
     */
    public void setConfirmListener(View.OnClickListener listener){
        Objects.requireNonNull((View) findViewById(R.id.btn_confirm)).setOnClickListener(
                v -> {
                    listener.onClick(v);
                    this.dismiss();
                }
        );
    }

    /***
     * set the Listener to buttons
     */
    private void setListeners(){
        // cancel button
        Button cancelButton = findViewById(R.id.btn_cancel);
        Objects.requireNonNull(cancelButton).setOnClickListener(
                v -> this.dismiss());

        // minus button
        Button minusButton = findViewById(R.id.minus);
        Objects.requireNonNull(minusButton).setOnClickListener(
                v -> {
                    if (getQuantity() != 1) {
                        quantityView.setText(String.valueOf(getQuantity() - 1));
                    }
                });

        // add button
        Button addButton = findViewById(R.id.add);
        Objects.requireNonNull(addButton).setOnClickListener(
                v -> quantityView.setText(String.valueOf(getQuantity() + 1)));

    }

    /***
     *
     * @return quantity selected
     */
    public int getQuantity(){
        return Integer.parseInt(quantityView.getText().toString());
    }

}
