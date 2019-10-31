// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: password.proto

package ie.gmit.ds;

/**
 * Protobuf type {@code ie.gmit.ds.PasswordInput}
 */
public  final class PasswordInput extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:ie.gmit.ds.PasswordInput)
    PasswordInputOrBuilder {
private static final long serialVersionUID = 0L;
  // Use PasswordInput.newBuilder() to construct.
  private PasswordInput(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private PasswordInput() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new PasswordInput();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private PasswordInput(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            ie.gmit.ds.Password.Builder subBuilder = null;
            if (password_ != null) {
              subBuilder = password_.toBuilder();
            }
            password_ = input.readMessage(ie.gmit.ds.Password.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(password_);
              password_ = subBuilder.buildPartial();
            }

            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return ie.gmit.ds.PasswordOuterClass.internal_static_ie_gmit_ds_PasswordInput_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return ie.gmit.ds.PasswordOuterClass.internal_static_ie_gmit_ds_PasswordInput_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            ie.gmit.ds.PasswordInput.class, ie.gmit.ds.PasswordInput.Builder.class);
  }

  public static final int PASSWORD_FIELD_NUMBER = 1;
  private ie.gmit.ds.Password password_;
  /**
   * <code>.ie.gmit.ds.Password password = 1;</code>
   */
  public boolean hasPassword() {
    return password_ != null;
  }
  /**
   * <code>.ie.gmit.ds.Password password = 1;</code>
   */
  public ie.gmit.ds.Password getPassword() {
    return password_ == null ? ie.gmit.ds.Password.getDefaultInstance() : password_;
  }
  /**
   * <code>.ie.gmit.ds.Password password = 1;</code>
   */
  public ie.gmit.ds.PasswordOrBuilder getPasswordOrBuilder() {
    return getPassword();
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (password_ != null) {
      output.writeMessage(1, getPassword());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (password_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getPassword());
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof ie.gmit.ds.PasswordInput)) {
      return super.equals(obj);
    }
    ie.gmit.ds.PasswordInput other = (ie.gmit.ds.PasswordInput) obj;

    if (hasPassword() != other.hasPassword()) return false;
    if (hasPassword()) {
      if (!getPassword()
          .equals(other.getPassword())) return false;
    }
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasPassword()) {
      hash = (37 * hash) + PASSWORD_FIELD_NUMBER;
      hash = (53 * hash) + getPassword().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static ie.gmit.ds.PasswordInput parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.gmit.ds.PasswordInput parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.gmit.ds.PasswordInput parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.gmit.ds.PasswordInput parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.gmit.ds.PasswordInput parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static ie.gmit.ds.PasswordInput parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static ie.gmit.ds.PasswordInput parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ie.gmit.ds.PasswordInput parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static ie.gmit.ds.PasswordInput parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static ie.gmit.ds.PasswordInput parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static ie.gmit.ds.PasswordInput parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static ie.gmit.ds.PasswordInput parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(ie.gmit.ds.PasswordInput prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code ie.gmit.ds.PasswordInput}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:ie.gmit.ds.PasswordInput)
      ie.gmit.ds.PasswordInputOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ie.gmit.ds.PasswordOuterClass.internal_static_ie_gmit_ds_PasswordInput_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ie.gmit.ds.PasswordOuterClass.internal_static_ie_gmit_ds_PasswordInput_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ie.gmit.ds.PasswordInput.class, ie.gmit.ds.PasswordInput.Builder.class);
    }

    // Construct using ie.gmit.ds.PasswordInput.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (passwordBuilder_ == null) {
        password_ = null;
      } else {
        password_ = null;
        passwordBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return ie.gmit.ds.PasswordOuterClass.internal_static_ie_gmit_ds_PasswordInput_descriptor;
    }

    @java.lang.Override
    public ie.gmit.ds.PasswordInput getDefaultInstanceForType() {
      return ie.gmit.ds.PasswordInput.getDefaultInstance();
    }

    @java.lang.Override
    public ie.gmit.ds.PasswordInput build() {
      ie.gmit.ds.PasswordInput result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public ie.gmit.ds.PasswordInput buildPartial() {
      ie.gmit.ds.PasswordInput result = new ie.gmit.ds.PasswordInput(this);
      if (passwordBuilder_ == null) {
        result.password_ = password_;
      } else {
        result.password_ = passwordBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof ie.gmit.ds.PasswordInput) {
        return mergeFrom((ie.gmit.ds.PasswordInput)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(ie.gmit.ds.PasswordInput other) {
      if (other == ie.gmit.ds.PasswordInput.getDefaultInstance()) return this;
      if (other.hasPassword()) {
        mergePassword(other.getPassword());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      ie.gmit.ds.PasswordInput parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (ie.gmit.ds.PasswordInput) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private ie.gmit.ds.Password password_;
    private com.google.protobuf.SingleFieldBuilderV3<
        ie.gmit.ds.Password, ie.gmit.ds.Password.Builder, ie.gmit.ds.PasswordOrBuilder> passwordBuilder_;
    /**
     * <code>.ie.gmit.ds.Password password = 1;</code>
     */
    public boolean hasPassword() {
      return passwordBuilder_ != null || password_ != null;
    }
    /**
     * <code>.ie.gmit.ds.Password password = 1;</code>
     */
    public ie.gmit.ds.Password getPassword() {
      if (passwordBuilder_ == null) {
        return password_ == null ? ie.gmit.ds.Password.getDefaultInstance() : password_;
      } else {
        return passwordBuilder_.getMessage();
      }
    }
    /**
     * <code>.ie.gmit.ds.Password password = 1;</code>
     */
    public Builder setPassword(ie.gmit.ds.Password value) {
      if (passwordBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        password_ = value;
        onChanged();
      } else {
        passwordBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.ie.gmit.ds.Password password = 1;</code>
     */
    public Builder setPassword(
        ie.gmit.ds.Password.Builder builderForValue) {
      if (passwordBuilder_ == null) {
        password_ = builderForValue.build();
        onChanged();
      } else {
        passwordBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.ie.gmit.ds.Password password = 1;</code>
     */
    public Builder mergePassword(ie.gmit.ds.Password value) {
      if (passwordBuilder_ == null) {
        if (password_ != null) {
          password_ =
            ie.gmit.ds.Password.newBuilder(password_).mergeFrom(value).buildPartial();
        } else {
          password_ = value;
        }
        onChanged();
      } else {
        passwordBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.ie.gmit.ds.Password password = 1;</code>
     */
    public Builder clearPassword() {
      if (passwordBuilder_ == null) {
        password_ = null;
        onChanged();
      } else {
        password_ = null;
        passwordBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.ie.gmit.ds.Password password = 1;</code>
     */
    public ie.gmit.ds.Password.Builder getPasswordBuilder() {
      
      onChanged();
      return getPasswordFieldBuilder().getBuilder();
    }
    /**
     * <code>.ie.gmit.ds.Password password = 1;</code>
     */
    public ie.gmit.ds.PasswordOrBuilder getPasswordOrBuilder() {
      if (passwordBuilder_ != null) {
        return passwordBuilder_.getMessageOrBuilder();
      } else {
        return password_ == null ?
            ie.gmit.ds.Password.getDefaultInstance() : password_;
      }
    }
    /**
     * <code>.ie.gmit.ds.Password password = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        ie.gmit.ds.Password, ie.gmit.ds.Password.Builder, ie.gmit.ds.PasswordOrBuilder> 
        getPasswordFieldBuilder() {
      if (passwordBuilder_ == null) {
        passwordBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            ie.gmit.ds.Password, ie.gmit.ds.Password.Builder, ie.gmit.ds.PasswordOrBuilder>(
                getPassword(),
                getParentForChildren(),
                isClean());
        password_ = null;
      }
      return passwordBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:ie.gmit.ds.PasswordInput)
  }

  // @@protoc_insertion_point(class_scope:ie.gmit.ds.PasswordInput)
  private static final ie.gmit.ds.PasswordInput DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new ie.gmit.ds.PasswordInput();
  }

  public static ie.gmit.ds.PasswordInput getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PasswordInput>
      PARSER = new com.google.protobuf.AbstractParser<PasswordInput>() {
    @java.lang.Override
    public PasswordInput parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new PasswordInput(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<PasswordInput> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PasswordInput> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public ie.gmit.ds.PasswordInput getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

