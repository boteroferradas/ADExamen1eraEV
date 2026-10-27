package Services;

import Connector.DBconnector;
import Models.Celta;
import Models.Xogador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CeltaService {
    public void crearXogadorCelta(Celta c){
        String sql = "INSERT INTO Celta (nome, posicion, idade)";
        try(Connection conn = DBconnector.conexion();
            PreparedStatement toInsert = conn.prepareStatement(sql)
        ){
            toInsert.setString(1, c.getNome());
            toInsert.setInt(2, c.getSoldo());
            toInsert.executeUpdate();

            System.out.println("Xogador do Celta insertado correctamente");

        } catch (SQLException e) {
            System.out.println("Erro ao insertar Xogador: " + e.getMessage());
        }
    }


    public static List<Celta> listarXogadoresCelta() {
        List<Celta> lista = new ArrayList<>();
        String sql = "SELECT * FROM Celta";
        try(Connection conn = DBconnector.conexion();
            PreparedStatement toRead = conn.prepareStatement(sql);
            ResultSet rs = toRead.executeQuery()
        ) {
            while (rs.next()){
                lista.add(new Celta(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getInt("soldo")
                        )
                );
            }
        }catch (SQLException e) {
            System.out.println("Erro ao leer a taboa Celta: " + e.getMessage());
        }
        return lista;
    }

    public static void actualizarSoldos(List<Celta> listaCelta) {
        String sql = "UPDATE Celta SET nome ?, soldo ? WHERE id = ?";
        //Creo que la sentencia esta mal porque no se como leer cada item de la lista y compararla
        try (Connection conn = DBconnector.conexion();
        PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            for (Celta c : listaCelta) {
                ps.setInt(2, c.getSoldo() * 2);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error ao actualizar os soldos: " + e.getMessage());
        }
    }

    public static void borrarContidoXogadoresCelta() {
        String sql = "DELETE * FROM Celta";
        try(Connection conn = DBconnector.conexion();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.executeUpdate();
        } catch (SQLException e ) {
            System.out.println("Erro ao borrar as taboas: " + e.getMessage());
        }
    }

}
