package com.practice.repository;

import com.practice.domain.prepare.GameId;
import com.practice.domain.prepare.Hand;
import com.practice.domain.prepare.PrepareField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class PrepareRepository implements IPrepareRepository {

    final JdbcTemplate jdbc;

    @Autowired
    public PrepareRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public PrepareField register(final PrepareField prepareField) {
        // FIXME:ここ、もうちょっと綺麗にできる気がする
        var playerId = createPlayer();
        registerHand(prepareField.getPlayer().getHand(), playerId);
        var dealerId = createDealer();
        registerHand(prepareField.getDealer().getHand(), dealerId);

        var sql = """
                INSERT INTO game(player_id, dealer_id)
                VALUES (?, ?)
                RETURNING game_id              
                """;
        var gameId = jdbc.queryForObject(sql, Long.class,
                playerId, dealerId);

        prepareField.setGameId(new GameId(gameId));
        return prepareField;
    }

    private UUID createPlayer() {
        var sql = """
                INSERT INTO player
                VALUES (?)
                RETURNING player_id
                """;
        var playerId = jdbc.queryForObject(sql, UUID.class, UUID.randomUUID());
        return playerId;
    }

    private UUID createDealer() {
        var sql = """
                INSERT INTO dealer
                VALUES (?)
                RETURNING dealer_id
                """;
        var dealerId = jdbc.queryForObject(sql, UUID.class, UUID.randomUUID());
        return dealerId;
    }

    private void registerHand(Hand hand, UUID holderId) {
        var sql = """
                INSERT INTO hand (holder_id, mark, number)
                VALUES (?, ?, ?)
                """;
        for (var card : hand.getCards()) {
            jdbc.update(sql, holderId,
                    card.getMark().name(),
                    card.getNumber().getValue());
        }
    }


}
