package Services;

import Connector.DBconnector;
import Models.Xogador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class XogadorServices {

    public void crearXogador(Xogador x){
        String sql = "INSERT INTO Xogadores (nome, posicion, idade) VALUES (?,?,?)";
        try(Connection conn = DBconnector.conexion();
            PreparedStatement toInsert = conn.prepareStatement(sql)
        ){
          toInsert.setString(1, x.getNome());
          toInsert.setString(2, x.getPosicion());
          toInsert.setInt(3, x.getIdade());
          toInsert.executeUpdate();

            System.out.println("Xogador insertado correctamente");

        } catch (SQLException e) {
            System.out.println("Erro ao insertar: " + e.getMessage());
        }
    }


    public static List<Xogador> listarXogadores() {
        List<Xogador> lista = new ArrayList<>();
        String sql = "SELECT * FROM Xogadores";
        try(Connection conn = DBconnector.conexion();
            PreparedStatement toRead = conn.prepareStatement(sql);
            ResultSet rs = toRead.executeQuery()
        ) {
            while (rs.next()){
                lista.add(new Xogador(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("posicion"),
                        rs.getInt("idade")
                        )
                );
            }
        }catch (SQLException e) {
            System.out.println("Erro ao leer a taboa Xogadores: " + e.getMessage());
        }
        return lista;
    }

    public List<Xogador> listarXogadoresMod(List<Xogador> listaMod) {
        List<Xogador> lista = new ArrayList<>();
        String sql = "SELECT * FROM Xogadores";
        try(Connection conn = DBconnector.conexion();
            PreparedStatement toRead = conn.prepareStatement(sql);
            ResultSet rs = toRead.executeQuery()
        ) {
            while (rs.next()){
                for (Xogador x : listaMod) {
                    if (x.getNome().equalsIgnoreCase(rs.getString("nome"))) {
                        lista.add(new Xogador(
                                        rs.getInt("id"),
                                        rs.getString("nome"),
                                        rs.getString("posicion"),
                                        rs.getInt("idade")
                                )
                        );
                    }
                }
            }
        }catch (SQLException e) {
            System.out.println("Erro ao leer a taboa Xogadores: " + e.getMessage());
        }
        return lista;
    }

    public void borrarContidoXogadores() {
        String sql = "DELETE * FROM Xogadores";
        try(Connection conn = DBconnector.conexion();
        PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.executeUpdate();
        } catch (SQLException e ) {
            System.out.println("Erro ao borrar as taboas: " + e.getMessage());
        }
    }
}
