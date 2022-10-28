package me.hero.passbatch.repository.pass;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import me.hero.passbatch.repository.BaseEntity;


@Getter
@Setter
@ToString
@Entity
@Table(name = "pass")
public class PassEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer passSeq;
    private Integer packageSeq;
    private String userId;

    private PassStatus status;
    private Integer remainingCount;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
    private LocalDateTime expiredAt;

}