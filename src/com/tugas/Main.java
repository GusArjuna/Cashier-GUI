package com.tugas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends JFrame{
    int i,j,totalBayar=0,uangPelanggan,uangKemablian;
    DataBarang[] stokn= new DataBarang[17];
    private JButton editStok,bayar,editBeli,hapusBeli,hapusStok,tambahBeli,tambahStok,infoPenggunaan,penotalan;
    private JTextField namaStok,hargaStok,jumlahBeli,jumlahStok,namaBeli,totalBeli,uangBayar,uangkembali;
    private JLabel nama,judul,barang,harga,nambel,barbel,stokLabel,beliLabel,harusBayar,diBayar,kembalian,subjudul;
    private JScrollPane jScrollPanestok,jScrollPanebeli;
    private String[] kolomTabel={"Nama Barang","Harga Barang","Jumlah Barang","Total Harga"};
    private Object[][] dataTabelbeli= {
            {null,null,null,null},{null,null,null,null},{null,null,null,null},{null,null,null,null},
            {null,null,null,null},{null,null,null,null},{null,null,null,null},{null,null,null,null},
            {null,null,null,null},{null,null,null,null},{null,null,null,null},{null,null,null,null},
            {null,null,null,null},{null,null,null,null},{null,null,null,null},{null,null,null,null},
            {null,null,null,null}
    };
    private Object[][] dataTabelstok= {
            {null,null,null,null},{null,null,null,null},{null,null,null,null},{null,null,null,null},
            {null,null,null,null},{null,null,null,null},{null,null,null,null},{null,null,null,null},
            {null,null,null,null},{null,null,null,null},{null,null,null,null},{null,null,null,null},
            {null,null,null,null},{null,null,null,null},{null,null,null,null},{null,null,null,null},
            {null,null,null,null}
    };
    private DefaultTableModel tmodelstok = new DefaultTableModel(dataTabelstok,kolomTabel);
    private DefaultTableModel tmodelbeli = new DefaultTableModel(dataTabelbeli,kolomTabel);
    private JTable tabelBeli,tabelStok;
    String inf="                  -------------------------How to Use this Program!---------------------------" +
            "\n* Tambah button on manajemen stok to add your stock on data tabel!" +
            "\n* Edit Button on manajemen stok to edit your stock on data tabel!" +
            "\n* Hapus Button on manajemen stok to remove your stock on data tabel!" +
            "\n* Tambah Button on pembilan to add thing what customer's want to buy on data tabel!" +
            "\n* Edit Button on pembilan to edit thing what customer's want to buy on data tabel!" +
            "\n* Hapus Button on pembilan to Remove thing what customer's want to buy on data tabel!" +
            "\n* Total Button serves to add up the entire of Customers purchases cost!" +
            "\n* Bayar Button to Apply Customerss Purchasing" +
            "\n\n How much customer's must pay it's appear on text field below after you click Total Button" +
            "\n and don't forget to add customer's money and click bayar button to apply Purchasing\n" +
            "\n*** THANK YOU FOR USING THIS PROGRAM , CODE BY M. TAUFAN MA'RUF - 1461900089***";


    public Main(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,700);
        setLocation(200,50);
        setBackground(Color.GREEN.darker());
        setForeground(Color.GREEN.darker());
        setVisible(true);
        adbuton();
        butonklik();
        textflid();
        labelnisasi();
        insialtabel();
        JOptionPane.showMessageDialog(null,inf);
    }

    private void insialtabel(){
        tabelStok=new JTable(tmodelstok);
        jScrollPanestok = new JScrollPane(tabelStok);
        add(jScrollPanestok,BorderLayout.CENTER);
        jScrollPanestok.setSize(430,290);
        jScrollPanestok.setLocation(10,150);

        tabelBeli=new JTable(tmodelbeli);
        jScrollPanebeli = new JScrollPane(tabelBeli);
        add(jScrollPanebeli,BorderLayout.CENTER);
        jScrollPanebeli.setSize(430,290);
        jScrollPanebeli.setLocation(510,150);
    }
    private void labelnisasi(){
        judul=new JLabel("WARU MART");
        add(judul);
        judul.setFont(new Font("Arial",Font.BOLD,25));
        judul.setBounds(400,10,180,30);
        judul.setForeground(Color.BLUE);

        subjudul=new JLabel("PT. Arjuna Company");
        add(subjudul);
        subjudul.setFont(new Font("Arial",Font.BOLD,12));
        subjudul.setBounds(420,25,150,30);

        stokLabel=new JLabel("Manajemen Stok");
        add(stokLabel);
        stokLabel.setFont(new Font("Arial",Font.BOLD,15));
        stokLabel.setBounds(150,25,120,30);

        beliLabel=new JLabel("Pembelian");
        add(beliLabel);
        beliLabel.setFont(new Font("Arial",Font.BOLD,15));
        beliLabel.setBounds(720,25,80,30);

        nama=new JLabel("Nama Barang");
        add(nama);
        nama.setBounds(10,50,100,30);

        barang=new JLabel("Jumlah Barang");
        add(barang);
        barang.setBounds(10,80,100,30);

        harga=new JLabel("Harga Barang");
        add(harga);
        harga.setBounds(10,110,100,30);

        nambel=new JLabel("Nama Barang");// beli
        add(nambel);
        nambel.setBounds(560,50,100,30);

        barbel=new JLabel("Jumlah Barang");
        add(barbel);
        barbel.setBounds(560,80,100,30);

        harusBayar=new JLabel("Total              Rp.");
        add(harusBayar);
        harusBayar.setFont(new Font("Arial",Font.BOLD,15));
        harusBayar.setBounds(550,500,125,30);

        diBayar=new JLabel("pembayaran Rp.");
        add(diBayar);
        diBayar.setFont(new Font("Arial",Font.BOLD,15));
        diBayar.setBounds(550,530,125,30);

        kembalian=new JLabel("kembalian     Rp.");
        add(kembalian);
        kembalian.setFont(new Font("Arial",Font.BOLD,15));
        kembalian.setBounds(550,560,125,30);
    }
    private void textflid(){
        namaStok = new JTextField();
        add(namaStok);
        namaStok.setSize(180,25);
        namaStok.setLocation(120,55);

        jumlahStok = new JTextField();
        add(jumlahStok);
        jumlahStok.setSize(180,25);
        jumlahStok.setLocation(120,85);

        hargaStok = new JTextField();
        add(hargaStok);
        hargaStok.setSize(180,25);
        hargaStok.setLocation(120,115);

        namaBeli = new JTextField();
        add(namaBeli);
        namaBeli.setSize(180,25);
        namaBeli.setLocation(670,55);

        jumlahBeli = new JTextField();
        add(jumlahBeli);
        jumlahBeli.setSize(180,25);
        jumlahBeli.setLocation(670,85);

        totalBeli = new JTextField();
        add(totalBeli);
        totalBeli.setSize(180,30);
        totalBeli.setLocation(675,500);

        uangBayar = new JTextField();
        add(uangBayar);
        uangBayar.setSize(180,30);
        uangBayar.setLocation(675,530);

        uangkembali = new JTextField();
        add(uangkembali);
        uangkembali.setSize(180,30);
        uangkembali.setLocation(675,560);
    }
    private void adbuton(){
        tambahStok= new JButton("Tambah");
        add(tambahStok);
        tambahStok.setLocation(310,55);
        tambahStok.setSize(80,25);
        tambahStok.setBackground(Color.ORANGE.darker());
        tambahStok.setForeground(Color.white);

        editStok= new JButton("Rubah");
        add(editStok);
        editStok.setLocation(310,85);
        editStok.setSize(80,25);
        editStok.setBackground(Color.ORANGE.darker());
        editStok.setForeground(Color.white);

        hapusStok= new JButton("Hapus");
        add(hapusStok);
        hapusStok.setLocation(310,115);
        hapusStok.setSize(80,25);
        hapusStok.setBackground(Color.red.darker());
        hapusStok.setForeground(Color.white);

        tambahBeli= new JButton("Tambah");
        add(tambahBeli);
        tambahBeli.setLocation(860,55);
        tambahBeli.setSize(80,25);
        tambahBeli.setBackground(Color.ORANGE.darker());
        tambahBeli.setForeground(Color.white);

        editBeli= new JButton("Rubah");
        add(editBeli);
        editBeli.setLocation(860,85);
        editBeli.setSize(80,25);
        editBeli.setBackground(Color.ORANGE.darker());
        editBeli.setForeground(Color.white);

        hapusBeli= new JButton("Hapus");
        add(hapusBeli);
        hapusBeli.setLocation(860,115);
        hapusBeli.setSize(80,25);
        hapusBeli.setBackground(Color.red.darker());
        hapusBeli.setForeground(Color.white);

        infoPenggunaan= new JButton("How To Use");
        add(infoPenggunaan);
        infoPenggunaan.setLocation(10,600);
        infoPenggunaan.setSize(120,25);
        infoPenggunaan.setBackground(Color.blue.darker());
        infoPenggunaan.setForeground(Color.white);

        bayar= new JButton("Bayar");
        add(bayar);
        bayar.setLocation(865,540);
        bayar.setSize(80,30);
        bayar.setBackground(Color.green.darker());
        bayar.setForeground(Color.white);

        penotalan= new JButton("Total");
        add(penotalan);
        penotalan.setLocation(865,500);
        penotalan.setSize(80,30);
        penotalan.setBackground(Color.green.darker());
        penotalan.setForeground(Color.white);
    }
    private void butonklik(){
        tambahStok.addActionListener(this::kliktambahstok);
        hapusStok.addActionListener(this::klikhapusstok);
        editStok.addActionListener(this::klikeditstok);
        tambahBeli.addActionListener(this::kliktambahbeli);
        hapusBeli.addActionListener(this::klikhapusbeli);
        editBeli.addActionListener(this::klikeditbeli);
        infoPenggunaan.addActionListener(this::klikinfo);
        bayar.addActionListener(this::klikbayar);
        penotalan.addActionListener(this::klikpenotalan);
    }

    private void kliktambahstok(ActionEvent e){
        if (namaStok.getText().equals("")||jumlahStok.getText().equals("")||hargaStok.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Nama / Jumlah barang / Harga Barang tidak boleh kosong!!");
        }else{
            if (Integer.parseInt(jumlahStok.getText())>0&&Integer.parseInt(hargaStok.getText())>0){
                for(i=0;i<17;i++){
                    if (namaStok.getText().toUpperCase().equals(dataTabelstok[i][0])){
                        JOptionPane.showMessageDialog(null,"Barang Sudah Ada Mohon Menggunakan Fasilitas Rubah");
                        namaStok.setText("");
                        hargaStok.setText("");
                        jumlahStok.setText("");
                        break;
                    }else {
                        if(dataTabelstok[i][0]==null){
                            try {
                            stokn[i] = new DataBarang();
                            dataTabelstok[i][1]=stokn[i].harga=Integer.parseInt(hargaStok.getText());
                            dataTabelstok[i][2]=stokn[i].jumlah=Integer.parseInt(jumlahStok.getText());
                            dataTabelstok[i][0]=stokn[i].nama=namaStok.getText().toUpperCase();
                            dataTabelstok[i][3]=stokn[i].totalharga=stokn[i].jumlah*stokn[i].harga;
                            tmodelstok.setValueAt(dataTabelstok[i][0],i,0);
                            tmodelstok.setValueAt(dataTabelstok[i][1],i,1);
                            tmodelstok.setValueAt(dataTabelstok[i][2],i,2);
                            tmodelstok.setValueAt(dataTabelstok[i][3],i,3);
                            namaStok.setText("");
                            hargaStok.setText("");
                            jumlahStok.setText("");
                            break;
                            }catch (Exception b){
                                JOptionPane.showMessageDialog(null,"Harga/Jumlah harus Berisi Angka");
                            }
                        }
                    }
                }
            }else {
                if (Integer.parseInt(jumlahStok.getText())<=0){
                    JOptionPane.showMessageDialog(null,"Jumlah Harus bernilai lebih dari 1");
                }else if (Integer.parseInt(hargaStok.getText())<=0){
                    JOptionPane.showMessageDialog(null,"Harga Harus bernilai lebih dari 1");
                }
            }
        }
    }

    private void klikhapusstok(ActionEvent e){
        j=tabelStok.getSelectedRow();
        dataTabelstok[j][0]=null;
        stokn[j].nama=null;
        dataTabelstok[j][1]=null;
        dataTabelstok[j][2]=null;
        dataTabelstok[j][3]=null;
        tmodelstok.setValueAt(dataTabelstok[j][0],j,0);
        tmodelstok.setValueAt(dataTabelstok[j][1],j,1);
        tmodelstok.setValueAt(dataTabelstok[j][2],j,2);
        tmodelstok.setValueAt(dataTabelstok[j][3],j,3);
    }

    private void klikeditstok(ActionEvent e){
        j=tabelStok.getSelectedRow();
        if (!namaStok.getText().equals("")){
            dataTabelstok[j][0]=stokn[j].nama=namaStok.getText().toUpperCase();
            tmodelstok.setValueAt(dataTabelstok[j][0],j,0);
        }
        if (!hargaStok.getText().equals("")){
            try {
                if (Integer.parseInt(hargaStok.getText())>0){
                    dataTabelstok[j][1]=stokn[j].harga=Integer.parseInt(hargaStok.getText());
                    tmodelstok.setValueAt(dataTabelstok[j][1],j,1);
                    dataTabelstok[j][3]=stokn[j].totalharga=stokn[j].jumlah*stokn[j].harga;
                    tmodelstok.setValueAt(dataTabelstok[j][3],j,3);
                }else {
                    JOptionPane.showMessageDialog(null,"harga Harus bernilai lebih dari 1");
                }
            }catch (Exception a){
                JOptionPane.showMessageDialog(null,"Harga harus Berisi Angka");
            }
        }
        if (!jumlahStok.getText().equals("")){
            try {
                if (Integer.parseInt(jumlahStok.getText())>0){
                    dataTabelstok[j][2]=stokn[j].jumlah=Integer.parseInt(jumlahStok.getText());
                    tmodelstok.setValueAt(dataTabelstok[j][2],j,2);
                    dataTabelstok[j][3]=stokn[j].totalharga=stokn[j].jumlah*stokn[j].harga;
                    tmodelstok.setValueAt(dataTabelstok[j][3],j,3);
                }else {
                    JOptionPane.showMessageDialog(null,"Jumlah Harus bernilai lebih dari 1");
                }
            }catch (Exception c){
                JOptionPane.showMessageDialog(null,"Jumlah harus Berisi Angka");
            }
        }
        namaStok.setText("");
        hargaStok.setText("");
        jumlahStok.setText("");
    }
    private void kliktambahbeli(ActionEvent e){
        if (namaBeli.getText().equals("")||jumlahBeli.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Nama / Jumlah barang tidak boleh kosong !!!");
        }else {
            if (Integer.parseInt(jumlahBeli.getText())>0){
                for(i=0;i<17;i++){
                    if(namaBeli.getText().toUpperCase().equals(stokn[i].nama)){
                        for(j=0;j<17;j++){
                            if (namaBeli.getText().toUpperCase().equals(dataTabelbeli[j][0])){
                                JOptionPane.showMessageDialog(null,"Barang Sudah Terinput Mphon Menggunakan" +
                                        "Fasilitas Rubah!");
                                namaBeli.setText("");
                                jumlahBeli.setText("");
                                break;
                            }else {
                                if(dataTabelbeli[j][0]==null){
                                    if (Integer.parseInt(jumlahBeli.getText())>stokn[i].jumlah){
                                        JOptionPane.showMessageDialog(null,"Stok Tidak Mencukupi!");
                                        break;
                                    }else {
                                        try {
                                            dataTabelbeli[j][2]=jumlahBeli.getText();
                                            dataTabelbeli[j][0]=namaBeli.getText().toUpperCase();
                                            dataTabelbeli[j][1]=stokn[i].harga;
                                            dataTabelbeli[j][3]=Integer.parseInt(jumlahBeli.getText())*stokn[i].harga;
                                            tmodelbeli.setValueAt(dataTabelbeli[j][0],j,0);
                                            tmodelbeli.setValueAt(dataTabelbeli[j][1],j,1);
                                            tmodelbeli.setValueAt(dataTabelbeli[j][2],j,2);
                                            tmodelbeli.setValueAt(dataTabelbeli[j][3],j,3);
                                            dataTabelstok[i][2]=stokn[i].jumlah=stokn[i].jumlah-Integer.parseInt(jumlahBeli.getText());
                                            dataTabelstok[i][3]=stokn[i].totalharga=stokn[i].jumlah*stokn[i].harga;
                                            tmodelstok.setValueAt(dataTabelstok[i][2],i,2);
                                            tmodelstok.setValueAt(dataTabelstok[i][3],i,3);
                                            namaBeli.setText("");
                                            jumlahBeli.setText("");
                                            break;
                                        }catch (Exception d){
                                            JOptionPane.showMessageDialog(null,"Jumlah harus Berisi Angka");
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }else if (i==16){
                        JOptionPane.showMessageDialog(null,"Stok Tidak Ada!");
                    }
                }
            }else {
                JOptionPane.showMessageDialog(null,"Jumlah Harus bernilai lebih dari 1");
            }
        }
    }
    private void klikhapusbeli(ActionEvent e){
        j=tabelBeli.getSelectedRow();
        int bantubeli=Integer.parseInt(String.valueOf(dataTabelbeli[j][2]));
        for (i=0;i<17;i++){
            if (dataTabelbeli[j][0].equals(dataTabelstok[i][0])){
                dataTabelstok[i][2]=stokn[i].jumlah+=bantubeli;
                tmodelstok.setValueAt(dataTabelstok[i][2],i,2);
            }
        }
        dataTabelbeli[j][0]=null;
        dataTabelbeli[j][1]=null;
        dataTabelbeli[j][2]=null;
        dataTabelbeli[j][3]=null;
        tmodelbeli.setValueAt(dataTabelbeli[j][0],j,0);
        tmodelbeli.setValueAt(dataTabelbeli[j][1],j,1);
        tmodelbeli.setValueAt(dataTabelbeli[j][2],j,2);
        tmodelbeli.setValueAt(dataTabelbeli[j][3],j,3);
    }
    private void klikeditbeli(ActionEvent e){
        j=tabelBeli.getSelectedRow();
        if (!namaBeli.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Tidak Bisa Mengubah Nama!");
        }else if (!jumlahBeli.getText().equals("")){
            if (Integer.parseInt(jumlahBeli.getText())>0){
                for (i=0;i<17;i++){
                    if (dataTabelbeli[j][0].equals(dataTabelstok[i][0])){
                        if (Integer.parseInt(jumlahBeli.getText())>(stokn[i].jumlah+Integer.parseInt(String.valueOf(dataTabelbeli[j][2])))){
                            JOptionPane.showMessageDialog(null,"Stok Tidak Mencukupi!");
                        }else {
                            if (Integer.parseInt(jumlahBeli.getText())>Integer.parseInt(String.valueOf(dataTabelbeli[j][2]))){
                                try {
                                    int rewang=Integer.parseInt(jumlahBeli.getText())-Integer.parseInt(String.valueOf(dataTabelbeli[j][2]));
                                    dataTabelstok[i][2]=stokn[i].jumlah-=rewang;
                                    tmodelstok.setValueAt(dataTabelstok[i][2],i,2);
                                    dataTabelstok[i][3]=stokn[i].totalharga=stokn[i].jumlah*stokn[i].harga;
                                    tmodelstok.setValueAt(dataTabelstok[i][3],i,3);
                                    dataTabelbeli[j][2]=Integer.parseInt(jumlahBeli.getText());
                                    tmodelbeli.setValueAt(dataTabelbeli[j][2],j,2);
                                    dataTabelbeli[j][3]=Integer.parseInt(jumlahBeli.getText())*stokn[i].harga;
                                    tmodelbeli.setValueAt(dataTabelbeli[j][3],j,3);
                                }catch (Exception f){
                                    JOptionPane.showMessageDialog(null,"Jumlah harus Berisi Angka");
                                }
                            }else {
                                try {
                                    int rewang=Integer.parseInt(String.valueOf(dataTabelbeli[j][2]))-Integer.parseInt(jumlahBeli.getText());
                                    dataTabelstok[i][2]=stokn[i].jumlah+=rewang;
                                    tmodelstok.setValueAt(dataTabelstok[i][2],i,2);
                                    dataTabelstok[i][3]=stokn[i].totalharga=stokn[i].jumlah*stokn[i].harga;
                                    tmodelstok.setValueAt(dataTabelstok[i][3],i,3);
                                    dataTabelbeli[j][2]=Integer.parseInt(jumlahBeli.getText());
                                    tmodelbeli.setValueAt(dataTabelbeli[j][2],j,2);
                                    dataTabelbeli[j][3]=Integer.parseInt(jumlahBeli.getText())*stokn[i].harga;
                                    tmodelbeli.setValueAt(dataTabelbeli[j][3],j,3);
                                }catch (Exception g){
                                    JOptionPane.showMessageDialog(null,"Jumlah harus Berisi Angka");
                                }
                            }
                        }
                        break;
                    }
                }
            }else {
                JOptionPane.showMessageDialog(null,"Jumlah Harus bernilai lebih dari 1");
            }
        }else {
            JOptionPane.showMessageDialog(null,"Jumlah harus di isi!");
        }
        namaBeli.setText("");
        jumlahBeli.setText("");
    }

    private void klikinfo(ActionEvent e){
        JOptionPane.showMessageDialog(null,inf);
    }
    private void klikbayar(ActionEvent e){
        Date date = new Date();
        SimpleDateFormat waktu = new SimpleDateFormat("E dd MMMM yyyy hh:mm:ss a");
        try{
            if (Integer.parseInt(uangBayar.getText())>0){
                uangPelanggan=Integer.parseInt(uangBayar.getText());
                if ((uangPelanggan-totalBayar)>=0){
                    uangKemablian=uangPelanggan-totalBayar;
                    uangkembali.setText(Integer.toString(uangKemablian));
                    String nota=" ----------------------------------------------------- NOTA PEMBAYARAN RESMI ------------------------" +
                            "---------------------------------------\n" +
                            waktu.format(date) +
                            "\n WARU MART" +
                            "\n PT. ARJUNA COMPANY\n\n";
                    for (i=0;i<17;i++){
                        if(dataTabelbeli[i][0]!=null){
                            nota+=(i+1)+". Nama Barang : "+dataTabelbeli[i][0]+" Harga Satuan : "+dataTabelbeli[i][1]+" Banyak Barang : " +
                                    dataTabelbeli[i][2]+" Total : "+dataTabelbeli[i][3]+"\n";
                        }
                    }
                    nota+="\n Total Biaya : "+totalBayar+
                            "\n Uang Bayar : "+uangPelanggan+
                            "\n Kembalian : "+uangKemablian+"" +
                            "\n\n Terima Kasih Sudah Berbelanja Di Tempat Kami! " +
                            "\n Anda Puas Kami Senang!" +
                            "Created By M. Taufan Ma'ruf - 1461900089--";
                    JOptionPane.showMessageDialog(null,nota);
                    for (i=0;i<17;i++){
                        for (j=0;j<4;j++){
                            dataTabelbeli[i][j]=null;
                            tmodelbeli.setValueAt(dataTabelbeli[i][j],i,j);
                        }
                    }
                    uangkembali.setText("");
                    uangBayar.setText("");
                    totalBeli.setText("");
                }else {
                    JOptionPane.showMessageDialog(null,"Uang Pembayaran Kurang!");
                }
            }else {
                JOptionPane.showMessageDialog(null,"Uang tidak boleh Minus");
            }
        }catch (Exception p){
            JOptionPane.showMessageDialog(null,"Masukkan Angka untuk Membayar");
        }
    }

    private void klikpenotalan(ActionEvent e){
        totalBayar=0;
        for (i=0;i<17;i++){
            if (dataTabelbeli[i][0]!=null){
                totalBayar=totalBayar+Integer.parseInt(String.valueOf(dataTabelbeli[i][3]));
            }else {
                break;
            }
        }
        totalBeli.setText(Integer.toString(totalBayar));
    }
    public static void main(String[] args) {new Main();}
}
class DataBarang {
    String nama;
    int jumlah,harga,totalharga;
}
