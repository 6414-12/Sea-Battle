package org.team.seabattle.server.view.dto;

public record RegisterDto(
  String name,
  String password,
  ImageDto image
) { }